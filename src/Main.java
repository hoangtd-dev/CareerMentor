void main() {
    Scanner scanner = new Scanner(System.in);
    final int LEVEL_INCREASEMENT = 1;
    final int GRADE_GAP = 3;
    double mathInput, englishInput, literatureInput, average, minGrade;
    char rate;

    while (true) {
        System.out.println("-----------------------------------");
        System.out.print("Enter your math point: ");
        mathInput = scanner.nextDouble();
        System.out.print("Enter your English point: ");
        englishInput  = scanner.nextDouble();
        System.out.print("Enter your literature point: ");
        literatureInput = scanner.nextDouble();

        if (mathInput < 0 || mathInput > 10 || englishInput < 0 || englishInput > 10 || literatureInput < 0 || literatureInput > 10) {
            System.out.println("Grade between 0-10");
            continue;
        }

        average = (mathInput + englishInput + literatureInput) / 3;

        if (mathInput < 5 || englishInput < 5 || literatureInput < 5) {
            _DisplayRating('F', average, mathInput, englishInput, literatureInput);
            continue;
        }


        minGrade = Math.min(Math.min(mathInput, englishInput), literatureInput);
        rate = average - GRADE_GAP > minGrade ? _RatingCalculation(minGrade + LEVEL_INCREASEMENT) : _RatingCalculation(average);
        _DisplayRating(rate, average, mathInput, englishInput, literatureInput);
    }
}

private char _RatingCalculation(double grade) {
   if (grade < 5) return 'F';
   else if (grade >= 5 && grade < 6) return 'D';
   else if (grade >= 6 && grade < 7) return 'C';
   else if (grade >= 7 && grade < 8) return 'B';
   else if (grade >= 8 && grade < 9) return 'A';
   else return 'S';
}

private void _DisplayRating(char rate, double average, double math, double english, double literature) {
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
