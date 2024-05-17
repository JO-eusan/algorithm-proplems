import java.io.*;

class Main 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());

        String[] tmp = br.readLine().split(" ");
        int[] stack_or_queue = new int[N];
        int queue_num = 0;
        for(int i=0; i<N; i++)
        {
            stack_or_queue[i] = Integer.parseInt(tmp[i]);
            if(stack_or_queue[i] == 0)
                queue_num++;
        }

        tmp = br.readLine().split(" ");
        int[] elements = new int[N];
        for(int i=0; i<N; i++)
            elements[i] = Integer.parseInt(tmp[i]);
        
        int M = Integer.parseInt(br.readLine());

        tmp = br.readLine().split(" ");
        int[] insert_numbers = new int[M];
        for(int i=0; i<M; i++)
            insert_numbers[i] = Integer.parseInt(tmp[i]);
        
        int[] result_order = new int[queue_num + M];
        int index = 0;

        for(int i=M-1; i>=0; i--)
            result_order[index++] = insert_numbers[i];
        for(int i=0; i<N; i++)
        {
            if(stack_or_queue[i] == 0)
                result_order[index++] = elements[i];
        }

        // print
        for(int i=result_order.length-1; i>=result_order.length-M; i--)
            bw.write(String.valueOf(result_order[i]) + " ");
            

        

        bw.flush();
        bw.close();
    }
}