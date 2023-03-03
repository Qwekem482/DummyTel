
# DummyTel

A fake Telecommunications Service Provider that was created for practising Software Testing in Software Testing and Quality Assurance course (INT3117).

**Run Test**

- Open \src\test\java\org\example\CallTest.java to run all tests
- Run equivalencePartitioning() in CallTest.java for Equivalence Partitioning Testing
- Run marginalValueAnalysis() in CallTest.java for Marginal Value Analysis Testing

## Equivalence Partitioning

**Partitioning**

| Duration = D                      | Start Time = ST                               |
|-----------------------------------|-----------------------------------------------|
| D1 = {X = seconds X > 3600}       | ST1 = {X = time; X < 08:00:00; X >= 18:00:00} |
| D2 = {X = seconds; 0 < X <= 3600} | ST2 = {X = time; 08:00:00 <= X < 18:00:00}    |
| D3 = {X = seconds; X <= 0}        |                                               |

**Test Cases**

|  STT  |       ST        |     D     |    Expected Result     |
|:-----:|:---------------:|:---------:|:----------------------:|
|   1   | ST1 = 09:00:00  | D1 = 5400 |         40.17          |
|   2   | ST1 = 09:00:00  | D2 = 2700 |         23.63          |
|   3   | ST1 = 09:00:00  |  D3 = -1  | Fail (throw Exception) |
|   4   | ST2 = 21:00:00  | D1 = 5400 |         20.09          |
|   5   | ST2 = 21:00:00  | D2 = 2700 |         11.82          |
|   6   | ST2 = 21:00:00  |  D3 = -1  | Fail (throw Exception) |

## Marginal Value Analysis

![](\img\Case3.png)
![](\img\Case4.png)
![](\img\Case1.png)
![](\img\Case2.png)
![](\img\Case5.png)
![](\img\Case6.png)



|     D     |       ST       |
|:---------:|:--------------:|
| D1 = -10  | ST1 = 08:00:00 |
|  D2 = -1  | ST2 = 08:00:01 |
|  D3 = 0   | ST3 = 13:00:00 |
|  D4 = 1   | ST4 = 17:59:59 |
| D5 = 2700 | ST5 = 18:00:00 |
| D6 = 3599 | ST6 = 18:00:01 |
| D7 = 3600 | ST7 = 00:00:00 |
| D8 = 3601 | ST8 = 07:59:59 |
| D9 = 5400 |                |

**Test Cases**

| STT | ST  |  D  |    Expected Result     |
|:---:|:---:|:---:|:----------------------:|
|  1  | ST1 | D1  | Fail (throw Exception) |
|  2  | ST1 | D2  | Fail (throw Exception) |
|  3  | ST1 | D3  |           0            |
|  4  | ST1 | D4  |          0.53          |
|  5  | ST1 | D5  |         23.63          |
|  6  | ST1 | D6  |          31.5          |
|  7  | ST1 | D7  |          31.5          |
|  8  | ST1 | D8  |         32.03          |
|  9  | ST1 | D9  |         40.17          |
| 10  | ST2 | D1  | Fail (throw Exception) |
| 11  | ST2 | D2  | Fail (throw Exception) |
| 12  | ST2 | D3  |           0            |
| 13  | ST2 | D4  |          0.53          |
| 14  | ST2 | D5  |         23.63          |
| 15  | ST2 | D6  |          31.5          |
| 16  | ST2 | D7  |          31.5          |
| 17  | ST2 | D8  |         32.03          |
| 18  | ST2 | D9  |         40.17          |
| 19  | ST3 | D1  | Fail (throw Exception) |
| 20  | ST3 | D2  | Fail (throw Exception) |
| 21  | ST3 | D3  |           0            |
| 22  | ST3 | D4  |          0.53          |
| 23  | ST3 | D5  |         23.63          |
| 24  | ST3 | D6  |          31.5          |
| 25  | ST3 | D7  |          31.5          |
| 26  | ST3 | D8  |         32.03          |
| 27  | ST3 | D9  |         40.17          |
| 28  | ST4 | D1  | Fail (throw Exception) |
| 29  | ST4 | D2  | Fail (throw Exception) |
| 30  | ST4 | D3  |           0            |
| 31  | ST4 | D4  |          0.53          |
| 32  | ST4 | D5  |         23.63          |
| 33  | ST4 | D6  |          31.5          |
| 34  | ST4 | D7  |          31.5          |
| 35  | ST4 | D8  |         32.03          |
| 36  | ST4 | D9  |         40.17          |
| 37  | ST5 | D1  | Fail (throw Exception) |
| 38  | ST5 | D2  | Fail (throw Exception) |
| 39  | ST5 | D3  |           0            |
| 40  | ST5 | D4  |          0.27          |
| 41  | ST5 | D5  |         11.82          |
| 42  | ST5 | D6  |         15.75          |
| 43  | ST5 | D7  |         15.75          |
| 44  | ST5 | D8  |         16.02          |
| 45  | ST5 | D9  |         20.09          |
| 46  | ST6 | D1  | Fail (throw Exception) |
| 47  | ST6 | D2  | Fail (throw Exception) |
| 48  | ST6 | D3  |           0            |
| 49  | ST6 | D4  |          0.27          |
| 50  | ST6 | D5  |         11.82          |
| 51  | ST6 | D6  |         15.75          |
| 52  | ST6 | D7  |         15.75          |
| 53  | ST6 | D8  |         16.02          |
| 54  | ST6 | D9  |         20.09          |
| 55  | ST7 | D1  | Fail (throw Exception) |
| 56  | ST7 | D2  | Fail (throw Exception) |
| 57  | ST7 | D3  |           0            |
| 58  | ST7 | D4  |          0.27          |
| 59  | ST7 | D5  |         11.82          |
| 60  | ST7 | D6  |         15.75          |
| 61  | ST7 | D7  |         15.75          |
| 62  | ST7 | D8  |         16.02          |
| 63  | ST7 | D9  |         20.09          |
| 64  | ST8 | D1  | Fail (throw Exception) |
| 65  | ST8 | D2  | Fail (throw Exception) |
| 66  | ST8 | D3  |           0            |
| 67  | ST8 | D4  |          0.27          |
| 68  | ST8 | D5  |         11.82          |
| 69  | ST8 | D6  |         15.75          |
| 70  | ST8 | D7  |         15.75          |
| 71  | ST8 | D8  |         16.02          |
| 72  | ST8 | D9  |         20.09          |

