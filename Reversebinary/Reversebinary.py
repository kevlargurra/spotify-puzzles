# -*- coding: utf-8 -*-

import sys

input_number = sys.stdin.readline()

new_bin_number = ''

for number in bin(int(input_number))[:1:-1]:
    new_bin_number = new_bin_number + number
    
print int(new_bin_number, 2)
