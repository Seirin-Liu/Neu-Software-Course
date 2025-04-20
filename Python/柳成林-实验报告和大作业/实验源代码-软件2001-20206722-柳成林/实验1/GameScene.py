import tkinter as tk
from tkinter import *
import math
import tkinter.messagebox
import SelectScene
X = "X"
O = "O"
EMPTY = " "



def new_board():
    board = []
    for i in range(9):
        board.append(EMPTY)
    return board


WAYS_TO_WIN = ((0, 1, 2), (3, 4, 5), (6, 7, 8), (0, 3, 6),
               (1, 4, 7), (2, 5, 8), (0, 4, 8), (2, 4, 6))


# 静态方法
def get_winner(board):
    for row in WAYS_TO_WIN:
        if board[row[0]] == board[row[1]] == board[row[2]] != EMPTY:
            winner = board[row[0]]
            # tkinter.messagebox.showinfo('消息提示', winner+'获胜')
            return winner

    if EMPTY not in board:
        return "TIE"
    return False


def legal_moves(board):
    moves = []
    for square in range(9):
        if board[square] == EMPTY:
            moves.append(square)
    return moves


BEST_MOVES = (4, 0, 2, 6, 8, 1, 3, 5, 7)  # 最佳下棋位置表


# 获取电脑最佳下棋点
def computer_move(board, computer, human):
    board = board[:]  # 创建副本，修改不影响原来列表board
    moves = legal_moves(board)
    for move in moves:  # 如果电脑能赢，就走那个位置
        board[move] = computer
        if get_winner(board) == computer:
            return move
        # 取消走棋方案
        board[move] = EMPTY  # 置为空，不影响下次判断

    for move in moves:  # 如果玩家能赢，就堵住那个位置
        board[move] = human
        if get_winner(board) == human:
            return move
        # 取消走棋方案
        board[move] = EMPTY

    for move in BEST_MOVES:
        if move in moves:
            return move


class Game:

    def __init__(self, root, select):
        self.root = root
        self.select = select  # 谁先手
        self.scene = tk.Frame(root)
        self.buttonbox = tk.Frame(self.scene)
        self.buttonbox.pack()
        self.scene.pack()
        self.scene.configure(bg="#FAEBD7")
        self.board = []
        self.num = 0
        self.w = tk.Canvas()

        newGameButton = tk.Button(self.buttonbox, text='新的游戏', bg="#FAF0E6", fg="black", width=20,
                                  command=lambda: self.new_game())
        newGameButton.pack(side="left")
        returnButton = tk.Button(self.buttonbox, text='返回', bg="#FAF0E6", fg="black", width=20,
                                 command=lambda: self.back())
        returnButton.pack(side="right")

        self.start_game(self.select)

    # 开始新游戏
    def new_game(self):
        self.w.destroy()
        self.start_game(self.select)

    # 返回主界面
    def back(self):
        self.scene.destroy()
        SelectScene.FirstScene(self.root)

    # 绘制棋子
    def draw(self, num, move):

        i = move % 3
        j = int((move - i) / 3)
        if num % 2 == 0:
            self.w.create_line(110 + 180 * i - 45 * math.sqrt(2), 110 + 180 * j - 45 * math.sqrt(2),
                               110 + 180 * i + 45 * math.sqrt(2), 110 + 180 * j + 45 * math.sqrt(2),
                               fill="#F08080", width=10)
            self.w.create_line(110 + 180 * i + 45 * math.sqrt(2), 110 + 180 * j - 45 * math.sqrt(2),
                               110 + 180 * i - 45 * math.sqrt(2), 110 + 180 * j + 45 * math.sqrt(2),
                               fill="#F08080", width=10)
        if num % 2 != 0:
            self.w.create_oval(40 + 180 * i, 40 + 180 * j, 180 * (i + 1), 180 * (j + 1), width=10, outline="#008080")


    def event(self, event):
        for i in range(0, 3):
            for j in range(0, 3):
                if 20 + j * 180 < event.y <= 20 + (j + 1) * 180:
                    break
            if 20 + i * 180 <= event.x <= 20 + (i + 1) * 180:
                break
        # 获取move值
        move = i + j * 3

        # 如果下棋的位置已经有棋
        if self.board[move] != EMPTY:
            return

        # 如果下棋的位置没有棋
        if self.board[move] == EMPTY:
            self.draw(self.num, move)
            self.board[move] = X
            self.num += 1

        # 判断是否胜利
        winner = get_winner(self.board)
        if winner:
            if winner == "TIE""":
                tkinter.messagebox.showinfo('消息提示', '平局')
                return
            tkinter.messagebox.showinfo('消息提示', winner + '获胜')
            self.w.destroy()
            return

        # 获取电脑下棋位置，并绘制棋子
        move = computer_move(self.board, O, X)
        self.draw(self.num, move)
        self.board[move] = O
        self.num += 1

        # 判断是否胜利
        winner = get_winner(self.board)
        if winner:
            if winner == "TIE""":
                tkinter.messagebox.showinfo('消息提示', '平局')
                return
            tkinter.messagebox.showinfo('消息提示', winner + '获胜')
            self.w.destroy()
            return


    def start_game(self, select):
        self.w = tk.Canvas(self.scene, width=580, height=580, background='#FFFAF0')
        self.w.pack()  # 绘制画布，放置画布
        self.board = new_board()  # 生成新的board
        self.num = select
        # 绘制棋盘
        for i in range(0, 4):
            self.w.create_line(i * 180 + 20, 20, i * 180 + 20, 560)
            self.w.create_line(20, i * 180 + 20, 560, i * 180 + 20)
        # 电脑先手，下一个棋
        if select == 1:
            move = computer_move(self.board, O, X)
            self.draw(self.num, move)
            self.board[move] = O
            self.num += 1
        # 事件绑定
        self.w.bind("<Button -1>", self.event)
