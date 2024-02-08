import java.util.*;

class Main 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        final int N = 20;

        double credit_sum = 0; // 나누는 수
        double grade_sum = 0; // 나눠지는 수

        for(int i=0; i<N; i++)
        {
            String name = scanner.next();
            String credit_tmp = scanner.next(); // double type
            String grade_tmp = scanner.next();

            double credit = Double.parseDouble(credit_tmp);
            double grade = 0;

            if(grade_tmp.equals("P"))
                continue;
            else
            {
                // grade를 과목 평점으로 변경
                switch(grade_tmp.charAt(0))
                {
                    case 'A':
                        if(grade_tmp.charAt(1) == '+')
                            grade = 4.5;
                        else if(grade_tmp.charAt(1) == '0')
                            grade = 4.0;
                        break;
                    case 'B':
                        if(grade_tmp.charAt(1) == '+')
                            grade = 3.5;
                        else if(grade_tmp.charAt(1) == '0')
                            grade = 3.0;
                        break;
                    case 'C':
                        if(grade_tmp.charAt(1) == '+')
                            grade = 2.5;
                        else if(grade_tmp.charAt(1) == '0')
                            grade = 2.0;
                        break;
                    case 'D':
                        if(grade_tmp.charAt(1) == '+')
                            grade = 1.5;
                        else if(grade_tmp.charAt(1) == '0')
                            grade = 1.0;
                        break;
                    case 'F':
                        grade = 0.0;
                        break;
                }

                credit_sum += credit;
                grade_sum += (credit*grade);

            }

        }

        System.out.print(grade_sum / credit_sum);

        scanner.close();
    }    
}