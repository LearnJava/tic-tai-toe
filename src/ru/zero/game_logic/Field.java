package ru.zero.game_logic;

public class Field {

	private final static byte NUMBER_OF_CELLS = 9;
	public final static byte ROW_COUNT = 3;
	public final static byte COL_COUNT = 3;
	private final Cell[][] arrayOfLogicCells = new Cell[ROW_COUNT][COL_COUNT];
	private final Byte[] coordinatesOfCell = new Byte[2];

	public static boolean gameOver;
	public static boolean isWin = false;
	public static boolean isLose = false;

	public Cell[][] getArray() {
		return arrayOfLogicCells;
	}

	public void generateField() {
		for (int i = 0; i < Field.COL_COUNT; i++) {
			for (int j = 0; j < Field.ROW_COUNT; j++) {
				arrayOfLogicCells[i][j] = new Cell();
			}
		}
	}

    private boolean checkForWinVertical() {

        for (int i = 0; i < ROW_COUNT; i++) {
            Cell cell1 = arrayOfLogicCells[i][0];
            Cell cell2 = arrayOfLogicCells[i][1];
            Cell cell3 = arrayOfLogicCells[i][2];

            if (cell1.isZeroChecked() && cell2.isZeroChecked()
                    && cell3.isZeroChecked()) {
                isWin = false;
                isLose = true;
                gameOver = true;
                return true;
            } else if (cell1.isXChecked() && cell2.isXChecked()
                    && cell3.isXChecked()) {
                isWin = true;
                isLose = false;
                gameOver = true;
                return true;
            }
        }
        return false;
    }

    private boolean checkForWinHorizontal() {

        for (int i = 0; i < COL_COUNT; i++) {
            Cell cell4 = arrayOfLogicCells[0][i];
            Cell cell5 = arrayOfLogicCells[1][i];
            Cell cell6 = arrayOfLogicCells[2][i];

            if (cell4.isZeroChecked() && cell5.isZeroChecked()
                    && cell6.isZeroChecked()) {
                isWin = false;
                isLose = true;
                gameOver = true;
                return true;
            } else if (cell4.isXChecked() && cell5.isXChecked()
                    && cell6.isXChecked()) {
                isWin = true;
                isLose = false;
                gameOver = true;
                return true;
            }
        }
        return false;
    }

    private boolean checkForWinDiagonal() {

        Cell cell7 = arrayOfLogicCells[0][0];
        Cell cell8 = arrayOfLogicCells[1][1];
        Cell cell9 = arrayOfLogicCells[2][2];

        if (((cell7.isZeroChecked()) && (cell8.isZeroChecked()) && (cell9
                .isZeroChecked()))) {
            isWin = false;
            isLose = true;
            gameOver = true;
            return true;
        } else if (cell7.isXChecked() && cell8.isXChecked()
                && cell9.isXChecked()) {
            isWin = true;
            isLose = false;
            gameOver = true;
            return true;
        }

        Cell cell10 = arrayOfLogicCells[0][2];
        Cell cell11 = arrayOfLogicCells[1][1];
        Cell cell12 = arrayOfLogicCells[2][0];

        if (cell10.isZeroChecked() && cell11.isZeroChecked()
                && cell12.isZeroChecked()) {
            isWin = false;
            isLose = true;
            gameOver = true;
            return true;
        } else if (cell10.isXChecked() && cell11.isXChecked()
                && cell12.isXChecked()) {
            isWin = true;
            isLose = false;
            gameOver = true;
            return true;
        }
        return false;
    }

	public boolean checkForWin() {

        if(checkForWinVertical() || checkForWinHorizontal() || checkForWinDiagonal()) {
            return  true;
        }

		if (ActionCounters.getCounter() >= 9) {
			isWin = true;
			isLose = true;
			gameOver = true;
			return true;
		}
		return false;
	}

//    public boolean checkForWin() {
//
//        for (int i = 0; i < ROW_COUNT; i++) {
//            Cell cell1 = arrayOfLogicCells[i][0];
//            Cell cell2 = arrayOfLogicCells[i][1];
//            Cell cell3 = arrayOfLogicCells[i][2];
//
//            if (cell1.isZeroChecked() && cell2.isZeroChecked() && cell3.isZeroChecked()) {
//                isWin = false;
//                isLose = true;
//                gameOver = true;
//                return true;
//            } else if (cell1.isXChecked() && cell2.isXChecked() && cell3.isXChecked()) {
//                isWin = true;
//                isLose = false;
//                gameOver = true;
//                return true;
//            }
//        }
//
//        for (int i = 0; i < COL_COUNT; i++) {
//            Cell cell4 = arrayOfLogicCells[0][i];
//            Cell cell5 = arrayOfLogicCells[1][i];
//            Cell cell6 = arrayOfLogicCells[2][i];
//
//            if (cell4.isZeroChecked() && cell5.isZeroChecked() && cell6.isZeroChecked()) {
//                isWin = false;
//                isLose = true;
//                gameOver = true;
//                return true;
//            } else if (cell4.isXChecked() && cell5.isXChecked() && cell6.isXChecked()) {
//                isWin = true;
//                isLose = false;
//                gameOver = true;
//                return true;
//            }
//        }
//
//        Cell cell7 = arrayOfLogicCells[0][0];
//        Cell cell8 = arrayOfLogicCells[1][1];
//        Cell cell9 = arrayOfLogicCells[2][2];
//
//        if (((cell7.isZeroChecked()) && (cell8.isZeroChecked()) && (cell9.isZeroChecked()))) {
//            isWin = false;
//            isLose = true;
//            gameOver = true;
//            return true;
//        } else if (cell7.isXChecked() && cell8.isXChecked() && cell9.isXChecked()) {
//            isWin = true;
//            isLose = false;
//            gameOver = true;
//            return true;
//        }
//
//        Cell cell10 = arrayOfLogicCells[0][2];
//        Cell cell11 = arrayOfLogicCells[1][1];
//        Cell cell12 = arrayOfLogicCells[2][0];
//
//        if (cell10.isZeroChecked() && cell11.isZeroChecked() && cell12.isZeroChecked()) {
//            isWin = false;
//            isLose = true;
//            gameOver = true;
//            return true;
//        } else if (cell10.isXChecked() && cell11.isXChecked() && cell12.isXChecked()) {
//            isWin = true;
//            isLose = false;
//            gameOver = true;
//            return true;
//        }
//
//        if(ActionCounters.getCounter() >= 9) {
//            isWin = true;
//            isLose = true;
//            gameOver = true;
//            return true;
//        }
//        return false;
//    }

	public Byte[] compMove() {

		if (findTwoZeroInHorizontalLine()) {
			return coordinatesOfCell;
		} else if (findTwoZeroInVerticalLine()) {
			return coordinatesOfCell;
		} else if (findTwoZeroInDiagonalLine1()) {
			return coordinatesOfCell;
		} else if (findTwoZeroInDiagonalLine2()) {
			return coordinatesOfCell;
		} else if (findTwoX_InVerticalLine()) {
			return coordinatesOfCell;
		} else if (findTwoX_InHorizontalLine()) {
			return coordinatesOfCell;
		} else if (findTwoX_InDiagonalLine1()) {
			return coordinatesOfCell;
		} else if (findTwoX_InDiagonalLine2()) {
			return coordinatesOfCell;
		} else if (arrayOfLogicCells[1][1].getIsClean()) {
			// Делаем ход в центр
			arrayOfLogicCells[1][1].computerMove();
			coordinatesOfCell[0] = 1;
			coordinatesOfCell[1] = 1;
			return coordinatesOfCell;
		} else {
			// ходим в любую свободную клетку
			while (true) {

				int counter = 0;
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (!arrayOfLogicCells[i][j].getIsClean()) {
							counter++;
						}

						if (counter == NUMBER_OF_CELLS) { // TODO
															// константа(ИСПРАВИЛ)
							return null;
						}
					}
				}

				coordinatesOfCell[0] = (byte) (Math.random() * 3);
				coordinatesOfCell[1] = (byte) (Math.random() * 3);

				if (arrayOfLogicCells[coordinatesOfCell[0]][coordinatesOfCell[1]]
						.getIsClean()) {
					arrayOfLogicCells[coordinatesOfCell[0]][coordinatesOfCell[1]]
							.computerMove();
					return coordinatesOfCell;
				}
			}
		}
	}

	private boolean findTwoZeroInHorizontalLine() {

		Cell cell1;
		Cell cell2;
		Cell cell3;
		boolean stopMove = false;
		byte symbolsCountInLine = 0;

		for (Byte i = 0; i < Field.ROW_COUNT; i++) {
			cell1 = arrayOfLogicCells[i][0];
			cell2 = arrayOfLogicCells[i][1];
			cell3 = arrayOfLogicCells[i][2];

			if (cell1.getIsZero() && !cell1.getIsClean()) {
				symbolsCountInLine++;
			}
			if (cell2.getIsZero() && !cell2.getIsClean()) {
				symbolsCountInLine++;
			}
			if (cell3.getIsZero() && !cell3.getIsClean()) {
				symbolsCountInLine++;
			}
			if (symbolsCountInLine == 2 && cell1.getIsClean()) {
				arrayOfLogicCells[i][0].computerMove();
				coordinatesOfCell[0] = i;
				coordinatesOfCell[1] = 0;
				stopMove = true;
			} else if (symbolsCountInLine == 2 && cell2.getIsClean()) {
				arrayOfLogicCells[i][1].computerMove();
				coordinatesOfCell[0] = i;
				coordinatesOfCell[1] = 1;
				stopMove = true;
			} else if (symbolsCountInLine == 2 && cell3.getIsClean()) {
				arrayOfLogicCells[i][2].computerMove();
				coordinatesOfCell[0] = i;
				coordinatesOfCell[1] = 2;
				stopMove = true;
			}
			symbolsCountInLine = 0;
		}
		return stopMove;
	}

	private boolean findTwoZeroInVerticalLine() {

		boolean stopMove = false;
		byte symbolsCountInLine = 0;

		Cell cell1;
		Cell cell2;
		Cell cell3;

		for (Byte i = 0; i < Field.ROW_COUNT; i++) {
			cell1 = arrayOfLogicCells[0][i];
			cell2 = arrayOfLogicCells[1][i];
			cell3 = arrayOfLogicCells[2][i];

			if (cell1.getIsZero() && !cell1.getIsClean()) {
				symbolsCountInLine++;
			}
			if (cell2.getIsZero() && !cell2.getIsClean()) {
				symbolsCountInLine++;
			}
			if (cell3.getIsZero() && !cell3.getIsClean()) {
				symbolsCountInLine++;
			}
			if (symbolsCountInLine == 2 && cell1.getIsClean()) {
				arrayOfLogicCells[0][i].computerMove();
				coordinatesOfCell[0] = 0;
				coordinatesOfCell[1] = i;
				stopMove = true;
			} else if (symbolsCountInLine == 2 && cell2.getIsClean()) {
				arrayOfLogicCells[1][i].computerMove();
				coordinatesOfCell[0] = 1;
				coordinatesOfCell[1] = i;
				stopMove = true;
			} else if (symbolsCountInLine == 2 && cell3.getIsClean()) {
				arrayOfLogicCells[2][i].computerMove();
				coordinatesOfCell[0] = 2;
				coordinatesOfCell[1] = i;
				stopMove = true;
			}
			symbolsCountInLine = 0;
		}
		return stopMove;
	}

	private boolean findTwoZeroInDiagonalLine1() {

		boolean stopMove = false;
		byte symbolsCountInLine = 0;

		Cell cell1 = arrayOfLogicCells[0][0];
		Cell cell2 = arrayOfLogicCells[1][1];
		Cell cell3 = arrayOfLogicCells[2][2];

		if (cell1.getIsZero() && !cell1.getIsClean()) {
			symbolsCountInLine++;
		}
		if (cell2.getIsZero() && !cell2.getIsClean()) {
			symbolsCountInLine++;
		}
		if (cell3.getIsZero() && !cell3.getIsClean()) {
			symbolsCountInLine++;
		}

		if (symbolsCountInLine == 2 && cell1.getIsClean()) {
			arrayOfLogicCells[0][0].computerMove();
			coordinatesOfCell[0] = 0;
			coordinatesOfCell[1] = 0;
			stopMove = true;
		} else if (symbolsCountInLine == 2 && cell2.getIsClean()) {
			arrayOfLogicCells[1][1].computerMove();
			coordinatesOfCell[0] = 1;
			coordinatesOfCell[1] = 1;
			stopMove = true;
		} else if (symbolsCountInLine == 2 && cell3.getIsClean()) {
			arrayOfLogicCells[2][2].computerMove();
			coordinatesOfCell[0] = 2;
			coordinatesOfCell[1] = 2;
			stopMove = true;
		}
		return stopMove;
	}

	private boolean findTwoZeroInDiagonalLine2() {

		boolean stopMove = false;
		byte symbolsCountInLine = 0;

		Cell cell1 = arrayOfLogicCells[0][2];
		Cell cell2 = arrayOfLogicCells[1][1];
		Cell cell3 = arrayOfLogicCells[2][0];

		if (cell1.getIsZero() && !cell1.getIsClean()) {
			symbolsCountInLine++;
		}
		if (cell2.getIsZero() && !cell2.getIsClean()) {
			symbolsCountInLine++;
		}
		if (cell3.getIsZero() && !cell3.getIsClean()) {
			symbolsCountInLine++;
		}

		if (symbolsCountInLine == 2 && cell1.getIsClean()) {
			arrayOfLogicCells[0][2].computerMove();
			coordinatesOfCell[0] = 0;
			coordinatesOfCell[1] = 2;
			stopMove = true;
		} else if (symbolsCountInLine == 2 && cell2.getIsClean()) {
			arrayOfLogicCells[1][1].computerMove();
			coordinatesOfCell[0] = 1;
			coordinatesOfCell[1] = 1;
			stopMove = true;
		} else if (symbolsCountInLine == 2 && cell3.getIsClean()) {
			arrayOfLogicCells[2][0].computerMove();
			coordinatesOfCell[0] = 2;
			coordinatesOfCell[1] = 0;
			stopMove = true;
		}
		return stopMove;
	}

	private boolean findTwoX_InVerticalLine() {

		byte symbolsCountInLine = 0;
		boolean stopMove = false;

		for (Byte i = 0; i < Field.ROW_COUNT; i++) {

			Cell cell1 = arrayOfLogicCells[i][0];
			Cell cell2 = arrayOfLogicCells[i][1];
			Cell cell3 = arrayOfLogicCells[i][2];

			if (!cell1.getIsZero() && !cell1.getIsClean()) {
				symbolsCountInLine++;
			}
			if (!cell2.getIsZero() && !cell2.getIsClean()) {
				symbolsCountInLine++;
			}
			if (!cell3.getIsZero() && !cell3.getIsClean()) {
				symbolsCountInLine++;
			}
			if (symbolsCountInLine == 2 && cell1.getIsClean()) {
				arrayOfLogicCells[i][0].computerMove();
				coordinatesOfCell[0] = i;
				coordinatesOfCell[1] = 0;
				stopMove = true;
			} else if (symbolsCountInLine == 2 && cell2.getIsClean()) {
				arrayOfLogicCells[i][1].computerMove();
				coordinatesOfCell[0] = i;
				coordinatesOfCell[1] = 1;
				stopMove = true;
			} else if (symbolsCountInLine == 2 && cell3.getIsClean()) {
				arrayOfLogicCells[i][2].computerMove();
				coordinatesOfCell[0] = i;
				coordinatesOfCell[1] = 2;
				stopMove = true;
			}
			symbolsCountInLine = 0;
		}
		return stopMove;
	}

	private boolean findTwoX_InHorizontalLine() {

		byte symbolsCountInLine = 0;
		boolean stopMove = false;

		for (Byte i = 0; i < Field.ROW_COUNT; i++) {
			Cell cell1 = arrayOfLogicCells[0][i];
			Cell cell2 = arrayOfLogicCells[1][i];
			Cell cell3 = arrayOfLogicCells[2][i];

			if (!cell1.getIsZero() && !cell1.getIsClean()) {
				symbolsCountInLine++;
			}
			if (!cell2.getIsZero() && !cell2.getIsClean()) {
				symbolsCountInLine++;
			}
			if (!cell3.getIsZero() && !cell3.getIsClean()) {
				symbolsCountInLine++;
			}
			if (symbolsCountInLine == 2 && cell1.getIsClean()) {
				arrayOfLogicCells[0][i].computerMove();
				coordinatesOfCell[0] = 0;
				coordinatesOfCell[1] = i;
				stopMove = true;
			} else if (symbolsCountInLine == 2 && cell2.getIsClean()) {
				arrayOfLogicCells[1][i].computerMove();
				coordinatesOfCell[0] = 1;
				coordinatesOfCell[1] = i;
				stopMove = true;
			} else if (symbolsCountInLine == 2 && cell3.getIsClean()) {
				arrayOfLogicCells[2][i].computerMove();
				coordinatesOfCell[0] = 2;
				coordinatesOfCell[1] = i;
				stopMove = true;
			}
			symbolsCountInLine = 0;
		}
		return stopMove;
	}

	private boolean findTwoX_InDiagonalLine1() {

		boolean stopMove = false;
		if ((!arrayOfLogicCells[0][0].getIsClean() && !arrayOfLogicCells[0][0]
				.getIsZero())
				&& (!arrayOfLogicCells[1][1].getIsClean() && !arrayOfLogicCells[1][1]
						.getIsZero()) && arrayOfLogicCells[2][2].getIsClean()) {

			arrayOfLogicCells[2][2].computerMove();
			coordinatesOfCell[0] = 2;
			coordinatesOfCell[1] = 2;

			stopMove = true;
		} else if ((!arrayOfLogicCells[0][0].getIsClean() && !arrayOfLogicCells[0][0]
				.getIsZero())
				&& (!arrayOfLogicCells[2][2].getIsClean() && !arrayOfLogicCells[2][2]
						.getIsZero()) && arrayOfLogicCells[1][1].getIsClean()) {
			arrayOfLogicCells[1][1].computerMove();
			coordinatesOfCell[0] = 1;
			coordinatesOfCell[1] = 1;

			stopMove = true;
		} else if ((!arrayOfLogicCells[1][1].getIsClean() && !arrayOfLogicCells[1][1]
				.getIsZero())
				&& (!arrayOfLogicCells[2][2].getIsClean() && !arrayOfLogicCells[2][2]
						.getIsZero()) && arrayOfLogicCells[0][0].getIsClean()) {
			arrayOfLogicCells[0][0].computerMove();
			coordinatesOfCell[0] = 0;
			coordinatesOfCell[1] = 0;

			stopMove = true;
		}

		return stopMove;
	}

	private boolean findTwoX_InDiagonalLine2() {
		boolean stopMove = false;
		if ((!arrayOfLogicCells[2][0].getIsClean() && !arrayOfLogicCells[2][0]
				.getIsZero())
				&& (!arrayOfLogicCells[1][1].getIsClean() && !arrayOfLogicCells[1][1]
						.getIsZero()) && arrayOfLogicCells[0][2].getIsClean()) {

			arrayOfLogicCells[0][2].computerMove();
			coordinatesOfCell[0] = 0;
			coordinatesOfCell[1] = 2;

			stopMove = true;
		} else if ((!arrayOfLogicCells[2][0].getIsClean() && !arrayOfLogicCells[2][0]
				.getIsZero())
				&& (!arrayOfLogicCells[0][2].getIsClean() && !arrayOfLogicCells[0][2]
						.getIsZero()) && arrayOfLogicCells[1][1].getIsClean()) {
			arrayOfLogicCells[1][1].computerMove();
			coordinatesOfCell[0] = 1;
			coordinatesOfCell[1] = 1;

			stopMove = true;
		} else if ((!arrayOfLogicCells[1][1].getIsClean() && !arrayOfLogicCells[1][1]
				.getIsZero())
				&& (!arrayOfLogicCells[0][2].getIsClean() && !arrayOfLogicCells[0][2]
						.getIsZero()) && arrayOfLogicCells[2][0].getIsClean()) {
			arrayOfLogicCells[2][0].computerMove();
			coordinatesOfCell[0] = 2;
			coordinatesOfCell[1] = 0;

			stopMove = true;
		}

		return stopMove;
	}

	public void userMove(byte x, byte y) {
		if (arrayOfLogicCells[x][y].getIsClean()) {
			arrayOfLogicCells[x][y].userMove();
		}
	}
}
