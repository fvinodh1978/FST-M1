import pytest
import math

def test_sum():
    num1 = 25
    num2=15
    assert num1+num2 == 40

def test_diff():
    num1 = 10
    num2 = 7
    assert num1-num2 == 3

def test_multiply():
    num1 = 10
    num2 = 5
    print("==============================", num1%num2)
    assert num1*num2 ==50

def test_div():
    num1 = 10
    num2 = 3
    assert num1//num2==3

def test_mod():
    num1 = 10
    num2 = 3
    assert num1%num2==1