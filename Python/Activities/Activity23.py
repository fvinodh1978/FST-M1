import pytest

def test_sum_list(init_list):
    sum=0
    for num in init_list:
        sum=sum+num
    assert sum==55