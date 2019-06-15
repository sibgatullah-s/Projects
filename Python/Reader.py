"""
This program reads csv files
"""

import csv

with open('Input.csv', 'r') as csvfile:
    reader = csv.reader(csvfile, delimiter = ',', quotechar = '|')
    Grid = []
    for row in reader:
        Grid.append(row)

filter = input("Filter by a province: ").strip()

with open('Output.csv', 'w', newline = '') as csvfile:
    writer = csv.writer(csvfile, delimiter = ',', quotechar = '|', quoting = csv.QUOTE_MINIMAL)
    writer.writerow(Grid[0]) #write first row
    for row in Grid:
        if filter in row:
            writer.writerow(row)
