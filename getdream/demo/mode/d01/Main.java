package com.getdream.demo.mode.d01;

public class Main {
}

interface Button {
}

interface Border {
}

class MacButton implements Button {
}

class MacBorder implements Border {
}

class WinButton implements Button {
}

class WinBorder implements Border {
}

class MacFactory {
    public static Button createButton() {
        return new MacButton();
    }

    public static Border createBorder() {
        return new MacBorder();
    }
}

class WinFactory {
    public static Button createButton() {
        return new WinButton();
    }

    public static Border createBorder() {
        return new WinBorder();
    }
}
