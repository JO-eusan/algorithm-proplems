import java.io.*;

class Main 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++)
        {
            String str = br.readLine();
            char[] result_str = new char[str.length()]; 
            int k = 0;
            int count = 0;

            for(int j=0; j<str.length(); j++)
            {   
                switch(str.charAt(j))
                {
                    case '@':
                        result_str[k++] = 'a'; count++;
                        break;
                    case '[':
                        result_str[k++] = 'c'; count++;
                        break;
                    case '!':
                        result_str[k++] = 'i'; count++;
                        break;
                    case ';':
                        result_str[k++] = 'j';; count++;
                        break;
                    case '^':
                        result_str[k++] = 'n'; count++;
                        break;
                    case '0':
                        result_str[k++] = 'o'; count++;
                        break;
                    case '7':
                        result_str[k++] = 't'; count++;
                        break;
                    case '\\':
                        if(str.charAt(j + 1) == '\'')
                        {
                            result_str[k++] = 'v'; count++;
                            j += 1;
                        }
                        else if(str.charAt(j + 1) == '\\')
                        {
                            result_str[k++] = 'w'; count++;
                            j += 2;
                        }
                        break;
                    default:
                        result_str[k++] = str.charAt(j);
                        break;
                }
            }
            if(count >= k/2.0)
                bw.write("I don't understand");
            else
            {
                for(int j=0; j<k; j++)
                    bw.write(result_str[j]);
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }    
}