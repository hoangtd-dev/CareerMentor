void main() {
    Scanner scanner = new Scanner(System.in);
    final int LEVEL_INCREASEMENT = 1;
    final int GRADE_GAP = 3;
    double mathInput, englishInput, literatureInput, average, minGrade;
    boolean isMinGradeTooFarAverage;
    boolean isLoop = true;
    char rate;

    while (isLoop) {
        System.out.println("-----------------------------------");
        System.out.print("Enter your math point: ");
        mathInput = scanner.nextDouble();
        System.out.print("Enter your English point: ");
        englishInput  = scanner.nextDouble();
        System.out.print("Enter your literature point: ");
        literatureInput = scanner.nextDouble();

        if (!_checkInputValid(mathInput) || !_checkInputValid(englishInput) || !_checkInputValid(literatureInput)) {
            System.out.println("Grade between 0-10");
            continue;
        }

        average = (mathInput + englishInput + literatureInput) / 3;
        minGrade = Math.min(Math.min(mathInput, englishInput), literatureInput);

        if (minGrade < 5) {
            _displayRating('F', average, mathInput, englishInput, literatureInput);
        } else {
            isMinGradeTooFarAverage = average - GRADE_GAP > minGrade;
            rate = isMinGradeTooFarAverage ? _getRatingByGrade(minGrade + LEVEL_INCREASEMENT) : _getRatingByGrade(average);
            _displayRating(rate, average, mathInput, englishInput, literatureInput);
        }

        isLoop = _askToContinue(scanner);
    }

    scanner.close();
}

private boolean _askToContinue(Scanner scanner) {
    System.out.print("Press 'Y' to continue, otherwise it will exit: ");
    String answer = scanner.next();
    return answer.equalsIgnoreCase("y");
}

private boolean _checkInputValid(double grade) {
    return grade >= 0 && grade <= 10;
}

private char _getRatingByGrade(double grade) {
    // Minh nen chon giua viec viet de hieu: else if (grade >= 5 && grade < 6) return 'D';
    // Hay giam viec phai check nhung dieu kien du thua nhung khien code kho hieu hon else if (grade < 6) return 'D';
   if (grade < 5) return 'F';
   else if (grade >= 5 && grade < 6) return 'D';
   else if (grade >= 6 && grade < 7) return 'C';
   else if (grade >= 7 && grade < 8) return 'B';
   else if (grade >= 8 && grade < 9) return 'A';
   else return 'S';
}

private void _displayRating(char rate, double average, double math, double english, double literature) {
    String formatAverage = String.format("%.2f", average);
    String template = "Math: " + math + "\nEnglish: " + english + "\nLiterature: " + literature + "\nAverage: " + formatAverage + "\n=> ";
    switch (rate) {
        case 'F':
            System.out.println(template + "Fail Student (Grade F)");
            break;
        case 'A':
            System.out.println(template + "Good Student (Grade A)");
            break;
        case 'B':
            System.out.println(template + "Normal Student (Grade B)");
            break;
        case 'C':
            System.out.println(template + "Average Student (Grade C)");
            break;
        case 'D':
            System.out.println(template + "Bad Student (Grade D)");
            break;
        default:
            System.out.println(template + "Excellent Student (Grade S)");
            break;
    }
}
