import tkinter as tk
import GameScene


class FirstScene:

    def __init__(self, root):
        self.root = root
        self.root.geometry("580x630")
        self.root.configure(bg="#FAEBD7")
        self.f = tk.Frame(self.root )
        self.f.pack()
        label = tk.Label(self.f, pady=20, font=('微软雅黑', 38), bg="#FAEBD7", fg='black', width=11, height=2, text="井字棋")
        label.pack()
        hButton = tk.Button(self.f, text='玩家先手', font=('微软雅黑', 25), bg="white", fg='black', width=17, height=2,
                            command=lambda: self.human_first())
        hButton.pack()
        cButton = tk.Button(self.f, text='电脑先手', font=('微软雅黑', 25), bg="white", fg='black', width=17, height=2,
                            command=lambda: self.computer_first())
        cButton.pack()

    def human_first(self):
        self.f.destroy()
        GameScene.Game(self.root, 0)

    def computer_first(self):
        self.f.destroy()
        GameScene.Game(self.root, 1)
