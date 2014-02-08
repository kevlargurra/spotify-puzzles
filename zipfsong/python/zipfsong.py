# -*- coding: utf-8 -*-

import sys

input = sys.stdin.readline()

[songs_on_album, songs_to_select] = input.split(' ')

quality_list = list()

song_order = 1
first_song_no_of_plays = 0

for songs in range(int(songs_on_album)):
    input = sys.stdin.readline()
    number_of_plays, song_name = input.split(' ')
    song_name = song_name.strip()
    if song_order == 1:
        first_song_no_of_plays = int(number_of_plays)
        
    if first_song_no_of_plays == 0:
        quality = 0
    else:
        quality = song_order * number_of_plays

    quality_list.append([quality, song_name, song_order])
    song_order = song_order + 1
    
quality_list.sort(reverse = True, key = lambda x : (x[0], -x[2]))

for list_index in range(int(songs_to_select)):
    print quality_list[list_index][1]
    

