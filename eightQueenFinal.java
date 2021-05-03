import java.util.*;
class eightQueenFinal
{
    char a[][]=new char[8][8];
    int count=0;
    void initialise()//initialises the 2-D to 0
    {
        int i,j;
        for (i=0;i<8;i++)
            for (j=0;j<8;j++)
                if (a[i][j] != 'B')
                    a[i][j]='0';

    }

    int count()//returns the total no of queens present
    {
        int i,j;
        int c=0;
        for (i=0;i<8;i++)
            for (j=0;j<8;j++)
                if (a[i][j] == ('Q'))
                    c++;
        return c;
    }

    void block(int x,int y)//blocks the places where queen cannot go
    {
        int i=0,j=0;
        for (j=0;j<8;j++)
            if (j != y)
                if (a[x][j] != 'B')
                    a[x][j]='1';
        for (i=0;i<8;i++)
            if (i != x)
                if (a[i][y] != 'B')
                    a[i][y]='1';
        i=x;j=y;
        if (x>=y)
        {
            i--;
            for (j=y-1;j>=0;j--)
            {
                if (a[i][j] != 'B')
                    a[i][j]='1';
                i--;
            }
            i=x;
            j=y;
            for (i=x+1;i<8;i++)
            {
                j++;
                if (a[i][j] != 'B')
                    a[i][j]='1';
            }
        }
        i=x;j=y;
        if (y>x)
        {
            j--;
            for (i=x-1;i>=0;i--)
            {
                if (a[i][j] != 'B')
                    a[i][j]='1';
                j--;
            }
            i=x;
            j=y;
            for (j=y+1;j<8;j++)
            {
                i++;
                if (a[i][j] != 'B')
                    a[i][j]='1';
            }
        }
        i=x;j=y;
        if (x<= (7-y))
        {
            j++;
            for (i=x-1;i>=0;i--)
            {
                if (a[i][j] != 'B')
                    a[i][j]='1';
                j++;
            }
            i=x;j=y;
            i++;
            for (j=y-1;j>=0;j--)
            {               
                if (a[i][j] != 'B')
                    a[i][j]='1';
                i++;
            }
        }
        i=x;j=y;
        if (x> (7-y))
        {
            j--;
            for (i=x+1;i<8;i++)
            {
                if (a[i][j] != 'B')
                    a[i][j]='1';
                j--;
            }
            i=x;j=y;
            for (j=y+1;j<8;j++)
            {
                i--;
                if (a[i][j] != 'B')
                    a[i][j]='1';
            }
        }
    }

    void display()//displays the matrix
    {
        int i,j;
        for (i=0;i<8;i++)
        {
            for (j=0;j<8;j++)
            {
                if (a[i][j] == 'Q')
                    System.out.print("Q\t");
                else
                    System.out.print("*\t");
            }
            System.out.println();
        }
    }

    void unblock(int x, int y)//blocks the places queen cannot go undoing the last queen
    {
        int i,j;
        for (i=0;i<8;i++)
            for (j=0;j<8;j++)
                if ((a[i][j] != 'Q')&& (a[i][j] != 'B'))
                    a[i][j]='0';
        
        for (i=0;i<8;i++)
        {
            for (j=0;j<8;j++)
            {
                if (i == x && j == y)
                    continue;
                if (a[i][j] == 'Q')
                    block(i,j);
            }
        }
    }

    void operate()//method to navigate 
    {
        int i,j,k,l,flag=0;
        initialise();
        for (i=0;i<8;i++)
        {
            for (j=0;j<8;j++)
            {
                if (a[i][j]=='0')
                {
                    a[i][j]='Q';
                    block(i,j);
                    if (i==7)
                    {
                        display();
                        count++;
                        System.out.println("\n ---------- \n");
                        a[i][j]='B';
                        i--;                       
                    }
                    break;
                }
                if (j==7 && i!=0)
                {
                    i--;
                    for (k=0;k<8;k++)
                    {
                        if (a[i][k]=='Q')
                            break;
                    }
                   
                    if (i != 7)
                    {
                        for (l=0;l<8;l++)
                            if (a[i+1][l]=='B')
                                a[i+1][l]='0';
                    } 
                    a[i][k]='B';
                    unblock(i,k);
                    i--;
                    break;
                }
                if (i==0 && j == 7)
                {
                    System.out.println("END");
                    flag=1;
                }
                
            }
            if (flag==1)
                break;
        }
        System.out.println("Total no of Solutions: "+count);
    }

    public static void main()//main method
    {
        eightQueenFinal ob=new eightQueenFinal();
        ob.operate();
    }
}
