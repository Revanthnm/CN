import java.util.*;

public class CRC
{
    public static int n;
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        CRC ob=new CRC();
        String code, copy, rec,zero="0000000000000000";
        System.out.print("Enter message :");
        code=in.nextLine();
        n=code.length();
        copy=code;
        code+=zero;
        code=ob.divide(code);
        System.out.println("Message="+copy);
        code=copy.substring(0,n)+code.substring(n);
        System.out.println("CRC="+code.substring(n));
        System.out.println("transmitted frame is "+code);
        System.out.println("Enter recived data");
        rec=in.nextLine();
        rec=copy+rec;
        if(zero.equals(ob.divide(rec).substring(n)))
            System.out.println("Correct bits recieved");
        else
            System.out.println("Recieved frame contains one or more errors");
        in.close();
    }
    public String divide(String s)
    {
        int i,j;
        char x;
        String div="10001000000100001";
        for(i=0;i<n;i++)
        {
            x=s.charAt(i);
            for(j=0;j<17;j++)
            {
                if(x=='1')
                {
                    if(s.charAt(i+j)!=div.charAt(j))
                    s=s.substring(0,i+j)+"1"+s.substring(i+j+1);
                    else
                    s=s.substring(0,i+j)+"0"+s.substring(i+j+1);
                }
            }
        }
        return s;
    }
}