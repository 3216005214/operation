package com.operation;
import java.util.*;
public class opera {
public static int[] fenshu(int range){//分数
	int[] a=new int[2];
	int q =1+(int)(Math.random()*range);
	int Q =1+(int)(Math.random()*range);
	if(q!=Q){
		a[0]=q;
		a[1]=Q;
	}
	else fenshu(range);
	return a;
}
public static int gongyueshu( int m, int n) //辗转相除法求m/n的公约数
{
    int r;
    while (n!=0)
    {
        r=m % n;
        m=n;
        n=r;
    }
    return m;
}
public static int gongbeishu(int m,int n) //最小公倍数
{
    return m*n/gongyueshu(m,n);
}
public static char yunsuanfu(){//随机运算符
	char[] b=new char[4];
	int B=(int)(Math.random()*4);
	b[0]='+';b[1]='-';b[2]='x';b[3]='÷';
	char n=b[B];
	return n;
}
public static int suijishu(int range){//随机整数
	int n=1+(int)(Math.random()*range);
	return n;
}
public static int[] suiji(int range){//返回随机数（包括分数、整数）
	int count[]=new int[8];
	for(int p = 0;p<8;p=p+2){
		int b=1+(int)(Math.random()*2);
		if(b==1){
			count[p]=suijishu(range);
			count[p+1]=1;
		}else if(b==2){
			int[] d=new int[2];
			d=fenshu(range);
	        count[p]=d[0];
	        count[p+1]=d[1];
		}
	}
	return count;
}
public static int[] zhenfenshu(int m,int n){
	int t=m;
	int i=1;
	while(t>n){
		t=m-(n*i);
		i++;
	}
	int[] d=new int[3];
	d[0]=i-1;
	d[1]=t;
	d[2]=n;
	if(t!=n){
		return d;
	}
	return d;
}

public static int duibi(String str){
	String[] a=new String[100];
	int p=0;
	for(int i=0;i<a.length;i++){
		a[i]=str;
		for(int j=0;j<a.length;j++){
			String sr1=a[i];
			String sr2=a[j];
			if(true==sr1.equals(sr2)){
			   p=1;
			   break;
			}else p=0;
}
	}
	return p;
}
public static void daan(int da[],ArrayList<String>Answer){
	if(da[0]!=0){
		if(da[1]==da[2]){
			Answer.add((da[0]+1)+"");
		}else if(da[1]!=0){
		Answer.add(da[0]+"'"+da[1]+"/"+da[2]);
		}else{
			Answer.add(da[1]+"");
		}
		}else {
			if(da[1]==da[2]){
				Answer.add(1+"");
			}
			else if(da[1]!=0&&da[1]!=da[2]){
			Answer.add(da[1]+"/"+da[2]);
			}else{Answer.add(da[1]+"");}
		}
}
public static char danyunsuan(int a,int b,int c, int d,ArrayList<Integer>Answer1,ArrayList<String>Question1){
    char o=yunsuanfu();
	int[] d1=new int[3];
	int[] d2=new int[3];
	int[] count=new int[]{a,b,c,d};
	if(gongyueshu(count[0],count[1])==0||gongyueshu(count[2],count[3])==0){
		return 0;
	}
	int x=count[0]/gongyueshu(count[0],count[1]);
	int y=count[1]/gongyueshu(count[0],count[1]);
	int z=count[2]/gongyueshu(count[2],count[3]);
	int p=count[3]/gongyueshu(count[2],count[3]);
	d1=zhenfenshu(x,y);
	d2=zhenfenshu(z,p);
	int n1=gongbeishu(count[1],count[3]);
    if(o=='-'){//当运算符为"-"号
    	if(count[1]==0||count[3]==0){return 0;}
	int an1=(count[0]*(n1/count[1]))-(count[2]*(n1/count[3]));
	if(an1>=0){
		if(gongyueshu(count[0],count[1])==count[1]&&gongyueshu(count[2],count[3])==count[3]){
			Question1.add((x/y)+" - "+(z/p));
		}
		else if(gongyueshu(count[0],count[1])==count[1]&&gongyueshu(count[2],count[3])!=count[3]){ 
		     if(d2[0]==0){
		    	 Question1.add((x/y)+" - "+d2[1]+"/"+d2[2]);
			}else{
				Question1.add((x/y)+" - "+d2[0]+"'"+d2[1]+"/"+d2[2]);
			}
		}
		else if(gongyueshu(count[0],count[1])!=count[1]&&gongyueshu(count[2],count[3])==count[3]){
			if(d1[0]==0){
				Question1.add(d1[1]+"/"+d1[2]+" - "+(z/p));
			}else{
				Question1.add(d1[0]+"'"+d1[1]+"/"+d1[2]+" - "+(z/p));
			}
		}
		else if(gongyueshu(count[0],count[1])!=count[1]&&gongyueshu(count[2],count[3])!=count[3]){
			if(d1[0]==0&&d2[0]==0){
				Question1.add(d1[1]+"/"+d1[2]+" - "+d2[1]+"/"+d2[2]);
			}else if(d1[0]!=0&&d2[0]==0){
				Question1.add(d1[0]+"'"+d1[1]+"/"+d1[2]+" - "+d2[1]+"/"+d2[2]);
			}else if(d1[0]==0&&d2[0]!=0){
				Question1.add(d1[1]+"/"+d1[2]+" - "+d2[0]+"'"+d2[1]+"/"+d2[2]);
			}else if(d1[0]!=0&&d2[0]!=0){
				Question1.add(d1[0]+"'"+d1[1]+"/"+d1[2]+" - "+d2[0]+"'"+d2[1]+"/"+d2[2]);
			}
		}
		
		Answer1.add(an1/gongyueshu(an1,n1));
		Answer1.add(n1/gongyueshu(an1,n1));
	}else{return 0;}
		return o;
		}
else if(o=='÷'){//当运算符为"÷"号
	if(count[2]==0){//除数为0时无意义
	    }  
	else if(count[2]!=0){
		int an2=count[0]*count[3];
		int an3=count[1]*count[2];
			if(gongyueshu(count[0],count[1])==count[1]&&gongyueshu(count[2],count[3])==count[3]){
				Question1.add((x/y)+" ÷ "+(z/p));
               }
			else if(gongyueshu(count[0],count[1])==count[1]&&gongyueshu(count[2],count[3])!=count[3]){ 
			     if(d2[0]==0){
			    	 Question1.add((x/y)+" ÷ "+d2[1]+"/"+d2[2]);
                  }else{
                	  Question1.add((x/y)+" ÷ "+d2[0]+"'"+d2[1]+"/"+d2[2]);
                    }
                       }
			else if(gongyueshu(count[0],count[1])!=count[1]&&gongyueshu(count[2],count[3])==count[3]){
				if(d1[0]==0){
					Question1.add(d1[1]+"/"+d1[2]+" ÷ "+(z/p));
                  }else{
                	  Question1.add(d1[0]+"'"+d1[1]+"/"+d1[2]+" ÷ "+(z/p));
               }
               }
			else if(gongyueshu(count[0],count[1])!=count[1]&&gongyueshu(count[2],count[3])!=count[3]){
				if(d1[0]==0&&d2[0]==0){
					Question1.add(d1[1]+"/"+d1[2]+" ÷ "+d2[1]+"/"+d2[2]);
                    }else if(d1[0]!=0&&d2[0]==0){
                    	Question1.add(d1[0]+"'"+d1[1]+"/"+d1[2]+" ÷ "+d2[1]+"/"+d2[2]);
                    }else if(d1[0]==0&&d2[0]!=0){
                    	Question1.add(d1[1]+"/"+d1[2]+" ÷ "+d2[0]+"'"+d2[1]+"/"+d2[2]);
                      }else if(d1[0]!=0&&d2[0]!=0){
                    	  Question1.add(d1[0]+"'"+d1[1]+"/"+d1[2]+" ÷ "+d2[0]+"'"+d2[1]+"/"+d2[2]);
                }
			}
		Answer1.add(an2/gongyueshu(an2,an3));
		Answer1.add(an3/gongyueshu(an2,an3));
		return o;
          }
}
else if(o=='+'){//当运算符为"+"号
	if(count[1]==0||count[3]==0){return 0;}
	int an4=(count[0]*(n1/count[1]))+(count[2]*(n1/count[3]));
		if(gongyueshu(count[0],count[1])==count[1]&&gongyueshu(count[2],count[3])==count[3]){
			Question1.add((x/y)+" + "+(z/p));
		}
		else if(gongyueshu(count[0],count[1])==count[1]&&gongyueshu(count[2],count[3])!=count[3]){ 
		     if(d2[0]==0){
		    	 Question1.add((x/y)+" + "+d2[1]+"/"+d2[2]);
			}else{
				Question1.add((x/y)+" + "+d2[0]+"'"+d2[1]+"/"+d2[2]);
			}
		}
		else if(gongyueshu(count[0],count[1])!=count[1]&&gongyueshu(count[2],count[3])==count[3]){
			if(d1[0]==0){
				Question1.add(d1[1]+"/"+d1[2]+" + "+(z/p));
			}else{
				Question1.add(d1[0]+"'"+d1[1]+"/"+d1[2]+" + "+(z/p));
			}
		}
		else if(gongyueshu(count[0],count[1])!=count[1]&&gongyueshu(count[2],count[3])!=count[3]){
			if(d1[0]==0&&d2[0]==0){
				Question1.add(d1[1]+"/"+d1[2]+" + "+d2[1]+"/"+d2[2]);
			}else if(d1[0]!=0&&d2[0]==0){
				Question1.add(d1[0]+"'"+d1[1]+"/"+d1[2]+" + "+d2[1]+"/"+d2[2]);
			}else if(d1[0]==0&&d2[0]!=0){
				Question1.add(d1[1]+"/"+d1[2]+" + "+d2[0]+"'"+d2[1]+"/"+d2[2]);
			}else if(d1[0]!=0&&d2[0]!=0){
				Question1.add(d1[0]+"'"+d1[1]+"/"+d1[2]+" + "+d2[0]+"'"+d2[1]+"/"+d2[2]);
			}
		}
		Answer1.add(an4/gongyueshu(an4,n1));
		Answer1.add(n1/gongyueshu(an4,n1));
		return o;
		}
else if(o=='x'){//当运算符为"x"号
	int an5=count[0]*count[2];
	int an6=count[1]*count[3];
		if(gongyueshu(count[0],count[1])==count[1]&&gongyueshu(count[2],count[3])==count[3]){
			Question1.add((x/y)+" x "+(z/p));
           }
		else if(gongyueshu(count[0],count[1])==count[1]&&gongyueshu(count[2],count[3])!=count[3]){ 
		     if(d2[0]==0){
		    	 Question1.add((x/y)+" x "+d2[1]+"/"+d2[2]);
              }else{
            	  Question1.add((x/y)+" x "+d2[0]+"'"+d2[1]+"/"+d2[2]);
                }
                   }
		else if(gongyueshu(count[0],count[1])!=count[1]&&gongyueshu(count[2],count[3])==count[3]){
			if(d1[0]==0){
				Question1.add(d1[1]+"/"+d1[2]+" x "+(z/p));
              }else{
            	  Question1.add(d1[0]+"'"+d1[1]+"/"+d1[2]+" x "+(z/p));
           }
           }
		else if(gongyueshu(count[0],count[1])!=count[1]&&gongyueshu(count[2],count[3])!=count[3]){
			if(d1[0]==0&&d2[0]==0){
				Question1.add(d1[1]+"/"+d1[2]+" x "+d2[1]+"/"+d2[2]);
                }else if(d1[0]!=0&&d2[0]==0){
                	Question1.add(d1[0]+"'"+d1[1]+"/"+d1[2]+" x "+d2[1]+"/"+d2[2]);
                }else if(d1[0]==0&&d2[0]!=0){
                	Question1.add(d1[1]+"/"+d1[2]+" x "+d2[0]+"'"+d2[1]+"/"+d2[2]);
                  }else if(d1[0]!=0&&d2[0]!=0){
                	  Question1.add(d1[0]+"'"+d1[1]+"/"+d1[2]+" x "+d2[0]+"'"+d2[1]+"/"+d2[2]);
            }
		}
			Answer1.add(an5/gongyueshu(an5,an6));
			Answer1.add(an6/gongyueshu(an5,an6));
			return o;
}
    
	return 0;
}

public static void main(String args[]){//主函数
	@SuppressWarnings("resource")
	Scanner input=new Scanner(System.in);
	System.out.println("请输入生成题目数：Myapp.exe -");
	int number=input.nextInt();//题目数
	System.out.println("请输入公式数值以及分数分母范围：Myapp.exe -");
	int range=input.nextInt();//数值范围
	int[] count =new int[8];
	int i=0;
	ArrayList<String>Answer=new ArrayList<String>();
	while(i<number){
		int[] arr1 = new int[6];
		count=suiji(range);
	    int a=1+(int)(Math.random()*3);
	    while(a==1){//当运算符为一位
	    	int[] d1=new int[3];
	    	int[] d2=new int[3];
	    	if(gongyueshu(count[0],count[1])==0||gongyueshu(count[2],count[3])==0){break;}
	    	int x=count[0]/gongyueshu(count[0],count[1]);
			int y=count[1]/gongyueshu(count[0],count[1]);
			int z=count[2]/gongyueshu(count[2],count[3]);
			int p=count[3]/gongyueshu(count[2],count[3]);
	    	d1=zhenfenshu(x,y);
	    	d2=zhenfenshu(z,p);
	    	int n1=gongbeishu(count[1],count[3]);
		    if(yunsuanfu()=='-'){//当运算符为"-"号
		    	if(count[1]==0||count[3]==0){break;}
			int an1=(count[0]*(n1/count[1]))-(count[2]*(n1/count[3]));
			if(an1>=0){//减法结果不能为负数	
				int[] arr2 = new int[] { count[0], count[1],count[2],count[4],an1,n1 };
				String str1 = Arrays.toString(arr2); 
			    if(duibi(str1)==0){break;}
				else{
				if(gongyueshu(count[0],count[1])==count[1]&&gongyueshu(count[2],count[3])==count[3]){
					System.out.println("<"+(i+1)+"> "+(x/y)+" - "+(z/p)+" =");
				}
				else if(gongyueshu(count[0],count[1])==count[1]&&gongyueshu(count[2],count[3])!=count[3]){ 
				     if(d2[0]==0){
						System.out.println("<"+(i+1)+"> "+(x/y)+" - "+d2[1]+"/"+d2[2]+" =");
					}else{
						System.out.println("<"+(i+1)+"> "+(x/y)+" - "+d2[0]+"'"+d2[1]+"/"+d2[2]+" =");
					}
				}
				else if(gongyueshu(count[0],count[1])!=count[1]&&gongyueshu(count[2],count[3])==count[3]){
					if(d1[0]==0){
	                    System.out.println("<"+(i+1)+"> "+d1[1]+"/"+d1[2]+" - "+(z/p)+" =");
					}else{
					System.out.println("<"+(i+1)+"> "+d1[0]+"'"+d1[1]+"/"+d1[2]+" - "+(z/p)+" =");
					}
				}
				else if(gongyueshu(count[0],count[1])!=count[1]&&gongyueshu(count[2],count[3])!=count[3]){
					if(d1[0]==0&&d2[0]==0){
						System.out.println("<"+(i+1)+"> "+d1[1]+"/"+d1[2]+" - "+d2[1]+"/"+d2[2]+" =");
					}else if(d1[0]!=0&&d2[0]==0){
						System.out.println("<"+(i+1)+"> "+d1[0]+"'"+d1[1]+"/"+d1[2]+" - "+d2[1]+"/"+d2[2]+" =");
					}else if(d1[0]==0&&d2[0]!=0){
						System.out.println("<"+(i+1)+"> "+d1[1]+"/"+d1[2]+" - "+d2[0]+"'"+d2[1]+"/"+d2[2]+" =");
					}else if(d1[0]!=0&&d2[0]!=0){
					System.out.println("<"+(i+1)+"> "+d1[0]+"'"+d1[1]+"/"+d1[2]+" - "+d2[0]+"'"+d2[1]+"/"+d2[2]+" =");
					}
				}
				System.arraycopy(arr2, 0, arr1, 0, arr1.length);
			    int[] da=new int[3];
				da=zhenfenshu(an1/gongyueshu(an1,n1),n1/gongyueshu(an1,n1));
				daan(da,Answer);
				
				i++;
				break;
				}
			}else if(an1<0){break;}
		}
		else if(yunsuanfu()=='÷'){//当运算符为"÷"号
			if(count[2]==0){//除数为0时无意义
			    break;
			    }  
			else if(count[2]!=0){
				int an2=count[0]*count[3];
				int an3=count[1]*count[2];
				int[] arr2 = new int[] { count[0], count[1],count[2],count[4],an2,an3,n1 };
				String str1 = Arrays.toString(arr2); 
			    if(duibi(str1)==0){i--;}
				else{
					if(gongyueshu(count[0],count[1])==count[1]&&gongyueshu(count[2],count[3])==count[3]){
						System.out.println("<"+(i+1)+"> "+(x/y)+" ÷ "+(z/p)+" =");
                       }
					else if(gongyueshu(count[0],count[1])==count[1]&&gongyueshu(count[2],count[3])!=count[3]){ 
					     if(d2[0]==0){
							System.out.println("<"+(i+1)+"> "+(x/y)+" ÷ "+d2[1]+"/"+d2[2]+" =");
                          }else{
							System.out.println("<"+(i+1)+"> "+(x/y)+" ÷ "+d2[0]+"'"+d2[1]+"/"+d2[2]+" =");
                            }
                               }
					else if(gongyueshu(count[0],count[1])!=count[1]&&gongyueshu(count[2],count[3])==count[3]){
						if(d1[0]==0){
		                    System.out.println("<"+(i+1)+"> "+d1[1]+"/"+d1[2]+" ÷ "+(z/p)+" =");
                          }else{
						System.out.println("<"+(i+1)+"> "+d1[0]+"'"+d1[1]+"/"+d1[2]+" ÷ "+(z/p)+" =");
                       }
                       }
					else if(gongyueshu(count[0],count[1])!=count[1]&&gongyueshu(count[2],count[3])!=count[3]){
						if(d1[0]==0&&d2[0]==0){
							System.out.println("<"+(i+1)+"> "+d1[1]+"/"+d1[2]+" ÷ "+d2[1]+"/"+d2[2]+" =");
                            }else if(d1[0]!=0&&d2[0]==0){
							System.out.println("<"+(i+1)+"> "+d1[0]+"'"+d1[1]+"/"+d1[2]+" ÷ "+d2[1]+"/"+d2[2]+" =");
                            }else if(d1[0]==0&&d2[0]!=0){
							System.out.println("<"+(i+1)+"> "+d1[1]+"/"+d1[2]+" ÷ "+d2[0]+"'"+d2[1]+"/"+d2[2]+" =");
                              }else if(d1[0]!=0&&d2[0]!=0){
						System.out.println("<"+(i+1)+"> "+d1[0]+"'"+d1[1]+"/"+d1[2]+" ÷ "+d2[0]+"'"+d2[1]+"/"+d2[2]+" =");
                        }
					}
						System.arraycopy(arr2, 0, arr1, 0, arr1.length);
					    int[] da=new int[3];
						da=zhenfenshu(an2/gongyueshu(an2,an3),an3/gongyueshu(an2,an3));
					daan(da,Answer);
                         }						
			    i++;
			    break;
                  }
                   }
                    
		else if(yunsuanfu()=='+'){//当运算符为"+"号
			if(count[1]==0||count[3]==0){break;}
			int an4=(count[0]*(n1/count[1]))+(count[2]*(n1/count[3]));
				int[] arr2 = new int[] { count[0], count[1],count[2],count[4],an4,n1 };
				String str1 = Arrays.toString(arr2); 
			    if(duibi(str1)==0){break;}
				else{
				if(gongyueshu(count[0],count[1])==count[1]&&gongyueshu(count[2],count[3])==count[3]){
					System.out.println("<"+(i+1)+"> "+(x/y)+" + "+(z/p)+" =");
				}
				else if(gongyueshu(count[0],count[1])==count[1]&&gongyueshu(count[2],count[3])!=count[3]){ 
				     if(d2[0]==0){
						System.out.println("<"+(i+1)+"> "+(x/y)+" + "+d2[1]+"/"+d2[2]+" =");
					}else{
						System.out.println("<"+(i+1)+"> "+(x/y)+" + "+d2[0]+"'"+d2[1]+"/"+d2[2]+" =");
					}
				}
				else if(gongyueshu(count[0],count[1])!=count[1]&&gongyueshu(count[2],count[3])==count[3]){
					if(d1[0]==0){
	                    System.out.println("<"+(i+1)+"> "+d1[1]+"/"+d1[2]+" + "+(z/p)+" =");
					}else{
					System.out.println("<"+(i+1)+"> "+d1[0]+"'"+d1[1]+"/"+d1[2]+" + "+(z/p)+" =");
					}
				}
				else if(gongyueshu(count[0],count[1])!=count[1]&&gongyueshu(count[2],count[3])!=count[3]){
					if(d1[0]==0&&d2[0]==0){
						System.out.println("<"+(i+1)+"> "+d1[1]+"/"+d1[2]+" + "+d2[1]+"/"+d2[2]+" =");
					}else if(d1[0]!=0&&d2[0]==0){
						System.out.println("<"+(i+1)+"> "+d1[0]+"'"+d1[1]+"/"+d1[2]+" + "+d2[1]+"/"+d2[2]+" =");
					}else if(d1[0]==0&&d2[0]!=0){
						System.out.println("<"+(i+1)+"> "+d1[1]+"/"+d1[2]+" + "+d2[0]+"'"+d2[1]+"/"+d2[2]+" =");
					}else if(d1[0]!=0&&d2[0]!=0){
					System.out.println("<"+(i+1)+"> "+d1[0]+"'"+d1[1]+"/"+d1[2]+" + "+d2[0]+"'"+d2[1]+"/"+d2[2]+" =");
					}
				}
				System.arraycopy(arr2, 0, arr1, 0, arr1.length);
			    int[] da=new int[3];
				da=zhenfenshu(an4/gongyueshu(an4,n1),n1/gongyueshu(an4,n1));
				daan(da,Answer);
				
				i++;
				break;
				}
			
		}
		else if(yunsuanfu()=='x'){//当运算符为"x"号
			int an5=count[0]*count[2];
			int an6=count[1]*count[3];
			int[] arr2 = new int[] { count[0], count[1],count[2],count[4],an5,an6,n1 };
			String str1 = Arrays.toString(arr2); 
		    if(duibi(str1)==0){i--;}
			else{
				if(gongyueshu(count[0],count[1])==count[1]&&gongyueshu(count[2],count[3])==count[3]){
					System.out.println("<"+(i+1)+"> "+(x/y)+" x "+(z/p)+" =");
                   }
				else if(gongyueshu(count[0],count[1])==count[1]&&gongyueshu(count[2],count[3])!=count[3]){ 
				     if(d2[0]==0){
						System.out.println("<"+(i+1)+"> "+(x/y)+" x "+d2[1]+"/"+d2[2]+" =");
                      }else{
						System.out.println("<"+(i+1)+"> "+(x/y)+" x "+d2[0]+"'"+d2[1]+"/"+d2[2]+" =");
                        }
                           }
				else if(gongyueshu(count[0],count[1])!=count[1]&&gongyueshu(count[2],count[3])==count[3]){
					if(d1[0]==0){
	                    System.out.println("<"+(i+1)+"> "+d1[1]+"/"+d1[2]+" x "+(z/p)+" =");
                      }else{
					System.out.println("<"+(i+1)+"> "+d1[0]+"'"+d1[1]+"/"+d1[2]+" x "+(z/p)+" =");
                   }
                   }
				else if(gongyueshu(count[0],count[1])!=count[1]&&gongyueshu(count[2],count[3])!=count[3]){
					if(d1[0]==0&&d2[0]==0){
						System.out.println("<"+(i+1)+"> "+d1[1]+"/"+d1[2]+" x "+d2[1]+"/"+d2[2]+" =");
                        }else if(d1[0]!=0&&d2[0]==0){
						System.out.println("<"+(i+1)+"> "+d1[0]+"'"+d1[1]+"/"+d1[2]+" x "+d2[1]+"/"+d2[2]+" =");
                        }else if(d1[0]==0&&d2[0]!=0){
						System.out.println("<"+(i+1)+"> "+d1[1]+"/"+d1[2]+" x "+d2[0]+"'"+d2[1]+"/"+d2[2]+" =");
                          }else if(d1[0]!=0&&d2[0]!=0){
					System.out.println("<"+(i+1)+"> "+d1[0]+"'"+d1[1]+"/"+d1[2]+" x "+d2[0]+"'"+d2[1]+"/"+d2[2]+" =");
                    }
				}
					System.arraycopy(arr2, 0, arr1, 0, arr1.length);
				    int[] da=new int[3];
					da=zhenfenshu(an5/gongyueshu(an5,an6),an6/gongyueshu(an5,an6));
					daan(da,Answer);
                     }						
		    i++;
		    break;
		}
	} 
	while(a==2){
		ArrayList<Integer>Answer1=new ArrayList<Integer>();
		ArrayList<String>Question1=new ArrayList<String>();
		int g=1+(int)(Math.random()*2);
		if(g==1){//(a[]b)[]c类型
			danyunsuan(count[0],count[1],count[2],count[3],Answer1,Question1);
			if(Answer1.size()==0||Question1.size()==0){break;}
			int a1=Answer1.get(0);int a2=Answer1.get(1);
			Answer1.clear();
			char h=danyunsuan(a1,a2,count[4],count[5],Answer1,Question1);
			int[] da=new int[3];
			da=zhenfenshu(count[4],count[5]);
			if(da[0]==0){
				if(da[1]==da[2]){
			System.out.println("<"+(i+1)+">"+"("+(Question1.get(0))+")"+" "+h+" "+1+"=");
				}else if(da[1]!=da[2]){
					System.out.println("<"+(i+1)+">"+"("+(Question1.get(0))+")"+" "+h+" "+da[1]+"/"+da[2]+"=");
				}
			}else if(da[0]!=0){
				if(da[1]!=da[2]){
				System.out.println("<"+(i+1)+">"+"("+(Question1.get(0))+")"+" "+h+" "+da[0]+"'"+da[1]+"/"+da[2]+"=");
				}else if(da[1]==da[2]){
					System.out.println("<"+(i+1)+">"+"("+(Question1.get(0))+")"+" "+h+" "+(da[0]+1)+"=");
				}
				}
			if(Answer1.size()==0||Question1.size()==0){break;}
			int[] w=new int[]{Answer1.get(0),Answer1.get(1)};
			int[] da1=new int[3];
			da1=zhenfenshu(w[0]/gongyueshu(w[0],w[1]),w[1]/gongyueshu(w[0],w[1]));
			daan(da1,Answer);
			i++;
			Answer1.clear();
		    Question1.clear();
		    break;
			}else if(g==2){//a[](b[]c)类型
			   danyunsuan(count[2],count[3],count[4],count[5],Answer1,Question1);
			     if(Answer1.size()==0||Question1.size()==0){break;}  
			     int a1=Answer1.get(0);int a2=Answer1.get(1);
			     Answer1.clear();
			     char h=danyunsuan(count[0],count[1],a1,a2,Answer1,Question1); 
			     int[] da=new int[3];   
			     da=zhenfenshu(count[0],count[1]);
			     if(da[0]==0){
				if(da[1]==da[2]){
			System.out.println("<"+(i+1)+">"+1+" "+h+" "+"("+(Question1.get(0))+")"+"=");
				}else if(da[1]!=da[2]){
					System.out.println("<"+(i+1)+">"+da[1]+"/"+da[2]+" "+h+" "+"("+(Question1.get(0))+")"+"=");
				}
			}else if(da[0]!=0){
				if(da[1]!=da[2]){
				System.out.println("<"+(i+1)+">"+da[0]+"'"+da[1]+"/"+da[2]+" "+h+" "+"("+(Question1.get(0))+")"+"=");
				}else if(da[1]==da[2]){
					System.out.println("<"+(i+1)+">"+(da[0]+1)+" "+h+" "+"("+(Question1.get(0))+")"+"=");
				}
				}
			if(Answer1.size()==0||Question1.size()==0){break;}
			int[] w=new int[]{Answer1.get(0),Answer1.get(1)};
			int[] da1=new int[3];
			da1=zhenfenshu(w[0]/gongyueshu(w[0],w[1]),w[1]/gongyueshu(w[0],w[1]));
			daan(da1,Answer);
			i++;
			Answer1.clear();
		    Question1.clear();
		    break;
			}
		}
    /*   while(a==3){//三个运算符
    	   ArrayList<Integer>Answer2=new ArrayList<Integer>();
   		   ArrayList<String>Question2=new ArrayList<String>();
   		   int f=1+(int)(Math.random()*8);
   		   if(f==1){//(a[]b)[]c[]d
   			   danyunsuan(count[0],count[1],count[2],count[3],Answer2,Question2);
   			   if(Answer2.size()==0||Question2.size()==0){break;}  
		       int a1=Answer2.get(0);int a2=Answer2.get(1);
		       Answer2.clear();
   		   }
       }*/
}
	System.out.println(Answer);
} 
}

