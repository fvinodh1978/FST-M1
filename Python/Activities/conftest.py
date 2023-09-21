import pytest

@pytest.fixture
def init_list():
    my_range=list(range(11))
    return my_range

@pytest.fixture
def wallet():
    amount=0
    return amount