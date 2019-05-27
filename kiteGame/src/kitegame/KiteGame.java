package kitegame;

import java.applet.Applet;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KiteGame implements KeyListener {

    int man1 = 0, man2 = 0, hit = 0, man3 = 0, man4 = 0, loop = 0, sx, sy, sx1, sy1, ex, ey, ex1, ey1, ck = 0, plane = 0, bulet = 0;
    boolean up = false;
    boolean down = false, kitefall = false, planefall = false;
    boolean left = false;
    boolean right = false, crt = false, a = false, s = false, d = false, w = false;
    int kite1x = 0, kite1y = 0;
    int kite2x = 0, kite2y = 0;
    int movx = 0, movy = 0, xy = 0, sun = 0, cloud = 0;
    int score;
    Image i;
    Graphics doubleG;

    public static void main(String[] args) {
        KiteGame ob = new KiteGame();
        ob.come();
    }

    public void come() {
        JFrame frame = new JFrame();
        My dr = new My();
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.add(dr);
        frame.setSize(1000, 600);
        addKeyListener(this);
        frame.setVisible(true);

        while (true) {
            ck++;
            plane++;
            bulet = bulet + 10;

            if (ck % 5 == 0) {
                cloud--;
            }
            if (ck % 30 == 0) {
                sun--;
            }
            if (crt == false) {
                dr.addKeyListener(this);
                loop++;
                if (loop < 100) {
                    kite2x--;
                    kite2y--;
                    kite1x++;
                    kite1y++;
                    man1++;
                    man3++;
                } else if (loop >= 100 && loop < 200) {
                    kite1x++;
                    kite1y--;
                    kite2y++;
                    kite2x++;
                    man2++;
                    man3--;
                } else if (loop >= 200 && loop < 300) {
                    kite1x--;
                    kite1y--;
                    kite2x--;
                    kite2y--;
                    man1--;
                    man3++;
                    //  System.out.println("im in");
                } else if (loop >= 300 && loop < 400) {
                    kite2x--;
                    kite2y++;
                    kite1x--;
                    kite1y++;

                    man3--;
                    man2--;
                } else {
                    loop = 0;
                    kite1x = 0;
                    kite2x = 0;
                    kite1y = 0;
                    kite2y = 0;
                }

            } /////////////////////////////////////////////////////all key function
            else {
                if (kitefall == false) {

                    ///////////////////////////////////////////////////////////////////////////////////////  
                    int tar;
                    if (plane > 1400) {
                        plane = 0;
                    }
                    if (bulet > 1400) {
                        bulet = plane;
                    }

                    // System.out.println(" sx=  "+sx1+" bulet=  "+(bulet+10));
                    tar = sy1 - 40;
                    if ((((bulet + 10) == sx1 || (bulet + 10) == (sx1 + 1) || (bulet + 10) == (sx1 + 2) || (bulet + 10) == (sx1 + 3) || (bulet + 10) == (sx1 + 4) || (bulet + 10) == (sx1 + 5) || (bulet + 10) == (sx1 + 6) || (bulet + 10) == (sx1 + 7) || (bulet + 10) == (sx1 + 8) || (bulet + 10) == (sx1 + 9)) && tar <= 90)) {
                        hit++;
                        kitefall = true;
                        System.out.println("kite hit  " + hit + "   sx=" + sx1);
                    }
                    if (tar >= 200) {
                        hit++;
                        kitefall = true;
                        System.out.println(" low hight  ");
                    }
                    dr.addKeyListener(this);
                    loop++;
                    if (loop < 100) {
                        kite2x--;
                        kite2y--;
                        kite1x++;
                        kite1y++;

                        man3++;
                    } else if (loop >= 100 && loop < 200) {
                        kite1x++;
                        kite1y--;
                        kite2y++;
                        kite2x++;

                        man3--;
                    } else if (loop >= 200 && loop < 300) {
                        kite1x--;
                        kite1y--;
                        kite2x--;
                        kite2y--;

                        man3++;
                        //  System.out.println("im in");
                    } else if (loop >= 300 && loop < 400) {
                        kite2x--;
                        kite2y++;
                        kite1x--;
                        kite1y++;

                        man3--;

                    } else {
                        loop = 0;
                        kite1x = 0;
                        kite2x = 0;
                        kite1y = 0;
                        kite2y = 0;
                    }

                    if (right == true) {
                        kite2x++;
                    }

                    if (left == true) {
                        kite2x--;
                    }

                    if (up == true) {
                        kite2y--;
                    }
                    if (down == true) {
                        kite2y++;
                    }//////////////////for man key

                    if (a == true) {
                        man1--;
                    }
                    if (s == true) {
                        man2++;
                    }
                    if (d == true) {
                        man1++;
                    }
                    if (w == true) {
                        man2--;
                    }
                    ////////////////

                    try {
                        Thread.sleep(5);
                    } catch (Exception ex) {
                    }

                }

                /////////////////////////////////////////////
            }
            if (cloud < -1400) {
                cloud = 0;
            }
            if (sun < -1400) {
                sun = 0;
            }
            if (plane > 1400) {
                plane = 0;
            }
            if (bulet > 1400) {
                bulet = plane;
            }
            if (kitefall == true && kite2y < 450) {
                kite2y++;
            }
            if(crt && !kitefall)
            score++;
            try {
                Thread.sleep(17);
            } catch (Exception ex) {
            }

            dr.repaint();
        }
        ////////////////////////////////////////////////////////////////
        //@Override
   
        /////////////////////////////////////////////////////////
        
        
    }

    private void addKeyListener(KiteGame aThis) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        int button = e.getKeyCode();

        if (button == KeyEvent.VK_C) {
            System.out.println("im in");
            crt = true;

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int button = e.getKeyCode();

        if (button == KeyEvent.VK_LEFT) {
            left = true;
        }
        if (button == KeyEvent.VK_RIGHT) {
            right = true;
        }
        if (button == KeyEvent.VK_UP) {
            up = true;
        }
        if (button == KeyEvent.VK_DOWN) {
            down = true;
        }
        if (button == KeyEvent.VK_C) {
            //System.out.println("im in");
            crt = true;

        }
        if (button == KeyEvent.VK_A) {
            a = true;
        }
        if (button == KeyEvent.VK_S) {
            s = true;
        }
        if (button == KeyEvent.VK_D) {
            d = true;
        }
        if (button == KeyEvent.VK_W) {
            w = true;
        }
    }
////////////////////////////////////////////////////////
 

    
    //////////////////////////////////////////////////////
    @Override
    public void keyReleased(KeyEvent e) {
        up = false;
        down = false;
        left = false;
        right = false;
        a = false;
        s = false;
        d = false;
        w = false;
    }

    class My extends Applet {
        ////////////////////////////////////////////////
        public void update(Graphics g) {
       if (i == null) {
           i = createImage(1440, 900);
            doubleG = i.getGraphics();
        }
        doubleG.setColor(getBackground());
        doubleG.fillRect(0, 0, 1440, 900);

        doubleG.setColor(getForeground());
        paint(doubleG);
        g.drawImage(i, 0, 0, this);
    }
        
        
        ////////////////////////////////////////

        public void paint(Graphics g) {
            movx = 0;
            movy = 0;
            xy = 0;
            g.setColor(Color.green);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(Color.CYAN);
            g.fillOval(-200, -100, 1800, 500);
            g.setColor(Color.MAGENTA);
            g.fillRect(260, 280, 15, 100);
            g.setColor(Color.green);
            g.fillOval(260, 270, 50, 40);
            g.fillOval(230, 270, 50, 40);
            g.fillOval(260, 250, 50, 40);
            g.fillOval(230, 245, 50, 40);
            g.fillOval(260, 230, 50, 40);
            g.fillOval(225, 220, 50, 40);
            g.fillOval(260, 240, 50, 40);
            g.fillOval(200, 245, 50, 40);
            g.setColor(Color.orange);////////////sun/////////////////
            g.fillOval(1200 + sun, 60, 100, 100);
            ///////////////////////////////////////////////////cloud
            g.setColor(Color.white);
            g.fillOval(1400 + cloud, 40, 200, 100);
            if (crt == true) {
                g.setColor(Color.red);
                g.fillOval(10 + bulet, 55, 10, 5);
            }////////////////////////////////////////////bulet
            g.setColor(Color.gray);
            g.fillOval(10 + plane, 50, 100, 20);
            g.setColor(Color.gray);
            g.fillOval(10 + plane, 30, 30, 30);
            g.setColor(Color.gray);
            g.fillOval(60 + plane, 30, 20, 60);

            g.setColor(Color.white);
            g.fillOval(1550 + cloud, 20, 100, 200);

            g.fillOval(1400 + cloud, 130, 300, 90);
            ///////////////////////////////////////////////////////////////////////////////////plane

            //////////////////////////////
            int[] o = {150, 200, 250};
            int[] p = {300, 250, 300};
            g.setColor(Color.orange);
            g.fillPolygon(o, p, 3);
            g.setColor(Color.blue);
            g.fillRect(158, 300, 82, 70);
            int[] w = {140, 155, 240, 255};
            int[] z = {380, 370, 370, 380};
            g.setColor(Color.RED);
            g.fillPolygon(w, z, 4);
            g.setColor(Color.YELLOW);
            g.fillRect(190, 320, 20, 50);
            // for another home

            int[] s = {260, 280, 360, 380};
            int[] t = {380, 370, 370, 380};
            g.setColor(Color.RED);
            g.fillPolygon(s, t, 4);
            int[] l = {270, 320, 370};
            int[] r = {300, 250, 300};
            g.setColor(Color.YELLOW);
            g.fillPolygon(l, r, 3);
            g.setColor(Color.DARK_GRAY);
            g.fillRect(279, 300, 82, 70);
            g.setColor(Color.YELLOW);
            g.fillRect(310, 315, 20, 54);

            ////////////////////////////////////////kite
            movy = 100;
            int[] sm = {80 + kite1x + movx + xy, 100 + kite1x + movx + xy, 80 + kite1x + movx + xy, 60 + kite1x + movx + xy};
            int[] il = {0 + kite1y + movy + xy, 40 + kite1y + movy + xy, 80 + kite1y + movy + xy, 40 + kite1y + movy + xy};
            sx = 80 + kite1x + movx + xy;
            sy = 80 + kite1y + movy + xy;
            g.setColor(Color.green);
            g.fillPolygon(sm, il, 4);

            g.setColor(Color.black);
            g.drawArc(63 + kite1x + movx, 27 + kite1y + movy, 35, 30, 0, 180);
            g.drawLine(80 + kite1x + movx, 0 + kite1y + movy, 80 + kite1x + movx, 80 + kite1y + movy);

            movx = 800;

            int[] sm1 = {80 + kite2x + movx + xy, 100 + kite2x + movx + xy, 80 + kite2x + movx + xy, 60 + kite2x + movx + xy};
            int[] il1 = {0 + kite2y + movy + xy, 40 + kite2y + movy + xy, 80 + kite2y + movy + xy, 40 + kite2y + movy + xy};
            g.setColor(Color.red);
            g.fillPolygon(sm1, il1, 4);
            g.setColor(Color.black);
            sx1 = 80 + kite2x + movx + xy;
            sy1 = 80 + kite2y + movy + xy;
            movx = 700;
            g.drawArc(63 + kite2x + 100 + movx, 27 + kite2y + movy, 35, 30, 0, 180);
            g.drawLine(80 + kite2x + 100 + movx, 0 + kite2y + movy, 80 + kite2x + 100 + movx, 80 + kite2y + movy);

//g.drawArc(718+frogx,590+frogy, 40,20,10,-180);
            ///////////////////////////////////lataie1
            movx = 356;
            movy = 450;
            g.setColor(Color.white);
            g.fillRect(movx + man3, movy + man4, 40, 20);
            g.fillRect(movx - 10 + man3, movy + man4 + 8, 60, 5);
            ex = movx - 10 + man3 + 30;
            ey = movy + 8 + man4;
            //////////////////////////////////////lataie2
            movx = 556;
            movy = 450;
            g.setColor(Color.yellow);
            g.fillRect(movx + man1, movy + man2, 40, 20);
            g.fillRect(movx - 10 + man1, movy + 8 + man2, 60, 5);
            ex1 = movx - 10 + man1 + 30;
            ey1 = movy + 8 + man2;

            movx = 0;
            movy = 0;
            //////////////////////////////////////////suta
            g.setColor(Color.black);
            g.drawLine(sx, sy - 40, ex, ey);
            g.setColor(Color.red);
            if (kitefall == false) {
                g.drawLine(sx1, sy1 - 40, ex1, ey1);
            }

            ////////////////////////////////////
            //////////////////////////////////////////for man
            g.setColor(Color.red);
            g.fillArc(569 + man1, 450 + man2, 80, 20, 10, 360);//hand

            g.fillArc(643 + man1, 450 + man2, 30, 60, 10, 360);//hand
            g.setColor(Color.yellow);
            g.fillRect(595 + man1, 450 + man2, 54, 65);//body

            int[] ar = {595 + man1, 650 + man1, 650 + man1, 630 + man1, 622 + man1, 614 + man1, 595 + man1};
            int[] ff = {515 + man2, 515 + man2, 580 + man2, 580 + man2, 525 + man2, 580 + man2, 580 + man2};
            g.setColor(Color.black);
            g.fillPolygon(ar, ff, 7);//pant
            g.setColor(Color.red);
            g.fillArc(566 + man1, 450 + man2, 30, 60, 10, 360);
            g.setColor(Color.yellow);
            g.fillRect(600 + man1, 580 + man2, 10, 20);//thaangg
            g.fillRect(610 + man1, 590 + man2, 15, 10);
            g.fillRect(635 + man1, 580 + man2, 10, 20);
            g.fillRect(635 + man1, 590 + man2, 20, 10);

            g.setColor(Color.black);
            g.fillOval(600 + man1, man2 + 400, 40, 50);//head

            ///////////////////////////////////////man 2
            movx = -200;
            g.setColor(Color.blue);
            g.fillArc(569 + man3 + movx, 450 + man4, 80, 20, 10, 360);//hand

            g.fillArc(643 + man3 + movx, 450 + man4, 30, 60, 10, 360);//hand
            g.setColor(Color.yellow);
            g.fillRect(595 + man3 + movx, 450 + man4, 54, 65);//body

            int[] ar1 = {595 + man3 + movx, 650 + man3 + movx, 650 + man3 + movx, 630 + man3 + movx, 622 + man3 + movx, 614 + man3 + movx, 595 + man3 + movx};
            int[] ff1 = {515 + man4, 515 + man4, 580 + man4, 580 + man4, 525 + man4, 580 + man4, 580 + man4};
            g.setColor(Color.black);
            g.fillPolygon(ar1, ff1, 7);//pant
            g.setColor(Color.blue);
            g.fillArc(566 + man3 + movx, 450 + man4, 30, 60, 10, 360);
            g.setColor(Color.yellow);
            g.fillRect(600 + man3 + movx, 580 + man4, 10, 20);//thaangg
            g.fillRect(610 + man3 + movx, 590 + man4, 15, 10);
            g.fillRect(635 + man3 + movx, 580 + man4, 10, 20);
            g.fillRect(635 + man3 + movx, 590 + man4, 20, 10);

            g.setColor(Color.black);
            g.fillOval(600 + man3 + movx, man4 + 400, 40, 50);
            movx = 0;
            movy = 0;
            ////////////////////////////////////
            Font f = new Font("SansSerif", Font.BOLD, 23);
            g.setFont(f);
            g.drawString(Integer.toString(score), 800, 550);
        }

    }

}
