package Image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageToRGB {
	
	
 
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Detection [][][] dt= new Detection[257][257][257];
		//Detection dt[][][];
		
		/*for(int i=0;i<255;i++) {
			for(int j=0;j<255;j++) {
				for(int k=0;k<255;k++) {
					dt[][][]=
				}
			}
		}*/
		
		BufferedWriter output = null;
        try {
        	
        	
        	
        	for(int i=0;i<3;i++) {
        		
        		String  st;
        		st=Integer.toString(i);
        		String path1,path2;
        		
        		path1="C:\\\\Users\\\\IITLAB\\\\Downloads\\\\ibtd\\\\Mask\\\\000"+st+".bmp";
        		
	            File file = new File("C:\\Users\\IITLAB\\eclipse-workspace\\ImageDitection\\example1.txt");
	            output = new BufferedWriter(new FileWriter(file));
	            
	    		BufferedImage bi=ImageIO.read(new File(path1));
	
	    		int countloop=0;  
	    		
	    		Boolean tag[][] = new Boolean[bi.getWidth()][bi.getHeight()]; 
	    		
	    		for (int x = 0; x <bi.getWidth(); x++) {
	    		    for (int y = 0; y < bi.getHeight(); y++) {
	    		       tag[x][y]=false;    	
	    		    }
	    	    }		
	    		
	    		for (int x = 0; x <bi.getWidth(); x++) {
	    		    for (int y = 0; y < bi.getHeight(); y++) {
	    		        Color c = new Color(bi.getRGB(x, y));
	    		        int xx,yy,zz;
	    		        xx=c.getRed();
	    		        yy=c.getGreen();
	    		        zz=c.getBlue();
	    		        
	    		        if(xx==255 &&  yy==255 && zz==255) {
	
	    		        	//System.out.println(xx+" "+yy+" "+zz);
	    		        }else {
	    		        	output.write(xx+" "+yy+" "+zz+"\n");
	    		        	tag[x][y] = true;   		        	
	    		        }                                                                                                                                              
	    		    }
	    		}
	    		
	    		path2="C:\\\\Users\\\\IITLAB\\\\Downloads\\\\ibtd\\\\000"+st+".jpg";
	    		BufferedImage bii =ImageIO.read(new File(path2));
	    		System.out.println(bi.getWidth()+"  "+bi.getHeight()+" "+bii.getWidth()+" "+bii.getHeight());
	    		System.out.println(path1+path2);
	    		//PointAttributes [][] 
	            //System.out.println("saikat");
	            PointAttributes [][] px = new PointAttributes[bii.getWidth()][bii.getHeight()];
	            
	    		for (int x = 0; x <bi.getWidth(); x++) {
	    		    for (int y = 0; y < bi.getHeight(); y++) {
	    		    	Color c = new Color(bi.getRGB(x, y));
	    		    	
			    		px[x][y] = new PointAttributes(c.getRed(), c.getGreen(), c.getBlue());
	  	
			    		
	    		    	if(tag[x][y]) {
	
	    		    		px[x][y].setSkin(1);;
	    		    	}else {
	    		    		
	    		    		px[x][y].setnonSkin(1);;
	    		    	}
	    		    }
	    		}
	    		
	    		for (int x = 0; x <bi.getWidth(); x++) {
	    		    for (int y = 0; y < bi.getHeight(); y++) {
	    		    	System.out.println(px[x][y].rr1+" "+px[x][y].gg+" "+px[x][y].bb+" "+px[x][y].skin+"  "+px[x][y].nonSkin);
	    		    	int xx,yy,zz;
	    		    	xx=px[x][y].rr1;
	    		    	yy=px[x][y].gg;
	    		   		zz=px[x][y].bb;
	    		   		System.out.println(xx+" "+yy+"  "+zz);
	    		    	dt[xx][yy][zz].setSkin(px[x][y].skin);
	    		    	dt[xx][yy][zz].setnonSkin(px[x][y].nonSkin);
	    		    }
	    		}
	    		
	    			
        	}
    		
    		for(int i=0;i<255;i++) {
    			for(int j=0;j<255;j++) {
    				for(int k=0;k<255;k++) {
    					//System.out.println(dt[i][j][k].getSkin()+"  "+dt[i][j][k].getnonSkin());
    				}
    			}
    		}
    		
    		
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        

		
	}

}
