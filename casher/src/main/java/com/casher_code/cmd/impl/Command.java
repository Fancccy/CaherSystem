package com.casher_code.cmd.impl;

import java.util.Scanner;

public interface Command { //�����������Ŀ���
    Scanner scanner = new Scanner(System.in);
    void execute(Subject subject);
}
