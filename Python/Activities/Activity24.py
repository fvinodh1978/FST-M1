import pytest

@pytest.mark.parametrize("earned, spent, expected", [(30, 10, 20), (20, 2, 18)])
def test_my_wallet(wallet, earned, spent, expected):
    amount=wallet+earned-spent
    assert amount==expected
