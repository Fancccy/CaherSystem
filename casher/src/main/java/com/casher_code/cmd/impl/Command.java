package com.casher_code.cmd.impl;

import java.util.Scanner;

public interface Command { //启动服务器的开关
    Scanner scanner = new Scanner(System.in);
    void execute(Subject subject);
}
