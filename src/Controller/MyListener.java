package Controller;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener for Tower Classes
 *
 * @author Gökhan Taş
 * @date 24.12.2019
 */
public class MyListener implements ActionListener {

    // Variables
    static boolean flag = View.GameSceneView.getFlag();;

    @Override
    public void actionPerformed(ActionEvent e) {

        // Variables
        Object source = e.getSource();
        String clickedButton;

        if( source != null ) {
            flag = !flag;
            clickedButton = ((JComponent) e.getSource()).getName();
            View.GameSceneView.getListOfClickedButtons().add(clickedButton);
            System.out.println( clickedButton );
            System.out.println(flag);

            if(View.GameSceneView.getListOfClickedButtons().size() == 2) {

                // Adding Poison Tower
                if(flag && View.GameSceneView.getListOfClickedButtons().get(0).equals("168") &&
                        !(View.GameSceneView.getListOfClickedButtons().get(1).equals("186")) && View.GameSceneView.getPlayer().getCoins() >= 7 ) {
                    System.out.println("tested");
                    View.GameSceneView.getPlayer().setCoins(View.GameSceneView.getPlayer().getCoins() - 7);
                    View.GameSceneView.getInfoCoin().setText("" + View.GameSceneView.getPlayer().getCoins());
                    View.GameSceneView.setTarget(View.GameSceneView.getTileList().get(Integer.parseInt(View.GameSceneView.getListOfClickedButtons().get(1))));
                    View.GameSceneView.setCheckPoison(true);
                    View.GameSceneView.getListOfClickedButtons().removeAll(View.GameSceneView.getListOfClickedButtons());
                }

                // Adding Electric Tower
                else if(flag && View.GameSceneView.getListOfClickedButtons().get(0).equals("185") &&
                        !(View.GameSceneView.getListOfClickedButtons().get(1).equals("186")) &&  View.GameSceneView.getPlayer().getCoins() >= 8 ) {
                    System.out.println("tested");
                    View.GameSceneView.getPlayer().setCoins(View.GameSceneView.getPlayer().getCoins() - 8);
                    View.GameSceneView.getInfoCoin().setText("" + View.GameSceneView.getPlayer().getCoins());
                    View.GameSceneView.setTarget(View.GameSceneView.getTileList().get(Integer.parseInt(View.GameSceneView.getListOfClickedButtons().get(1))));
                    View.GameSceneView.setCheckElectric(true);
                    View.GameSceneView.getListOfClickedButtons().removeAll(View.GameSceneView.getListOfClickedButtons());
                }

                // Adding Fire Tower
                else if(flag && View.GameSceneView.getListOfClickedButtons().get(0).equals("151") &&
                        !( View.GameSceneView.getListOfClickedButtons().get(1).equals("186")) && View.GameSceneView.getPlayer().getCoins() >= 7 ) {
                    System.out.println("tested");
                    View.GameSceneView.getPlayer().setCoins(View.GameSceneView.getPlayer().getCoins() - 7);
                    View.GameSceneView.getInfoCoin().setText("" + View.GameSceneView.getPlayer().getCoins());
                    View.GameSceneView.setTarget(View.GameSceneView.getTileList().get(Integer.parseInt(View.GameSceneView.getListOfClickedButtons().get(1))));
                    View.GameSceneView.setCheckFire(true);
                    View.GameSceneView.getListOfClickedButtons().removeAll(View.GameSceneView.getListOfClickedButtons());
                }
                // Adding Earth Tower
                else if(flag && View.GameSceneView.getListOfClickedButtons().get(0).equals("152") &&
                        !(View.GameSceneView.getListOfClickedButtons().get(1).equals("186")) && View.GameSceneView.getPlayer().getCoins() >= 7 ) {
                    System.out.println("tested");
                    View.GameSceneView.getPlayer().setCoins(View.GameSceneView.getPlayer().getCoins() - 7);
                    View.GameSceneView.getInfoCoin().setText("" + View.GameSceneView.getPlayer().getCoins());
                    View.GameSceneView.setTarget(View.GameSceneView.getTileList().get(Integer.parseInt(View.GameSceneView.getListOfClickedButtons().get(1))));
                    View.GameSceneView.setCheckEarth(true);
                    View.GameSceneView.getListOfClickedButtons().removeAll(View.GameSceneView.getListOfClickedButtons());
                }

                // Adding Water Tower
                else if(flag && View.GameSceneView.getListOfClickedButtons().get(0).equals("169") &&
                        !(View.GameSceneView.getListOfClickedButtons().get(1).equals("186")) &&  View.GameSceneView.getPlayer().getCoins() >= 7 ) {
                    System.out.println("tested");
                    View.GameSceneView.getPlayer().setCoins(View.GameSceneView.getPlayer().getCoins() - 7);
                    View.GameSceneView.getInfoCoin().setText("" + View.GameSceneView.getPlayer().getCoins());
                    View.GameSceneView.setTarget(View.GameSceneView.getTileList().get(Integer.parseInt(View.GameSceneView.getListOfClickedButtons().get(1))));
                    View.GameSceneView.setCheckWater(true);
                    View.GameSceneView.getListOfClickedButtons().removeAll(View.GameSceneView.getListOfClickedButtons());
                }

                // Checking whether it can be upgraded or not
                else if( View.GameSceneView.getListOfClickedButtons().get(0).equals("186")) {
                    for(int i = 0; i < View.GameSceneView.getListOfTowers().size(); i++) {
                        if ( View.GameSceneView.getListOfClickedButtons().get(1).equals( View.GameSceneView.getListOfTowers().get(i).getTowerName())
                                &&  View.GameSceneView.getListOfTowers().get(i).getLevel() < 3
                                && View.GameSceneView.getPlayer().getCoins() >= 10 ) {
                            View.GameSceneView.getListOfTowers().get(i).upgradeTower();
                            View.GameSceneView.getPlayer().setCoins(View.GameSceneView.getPlayer().getCoins() - 10);
                            View.GameSceneView.getInfoCoin().setText("" +View.GameSceneView.getPlayer().getCoins());
                            System.out.println("UPGRADED");
                        }
                        else {
                            System.out.println("NOT UPGRADED");
                        }
                    }
                    View.GameSceneView.getListOfClickedButtons().removeAll(View.GameSceneView.getListOfClickedButtons());
                }
                else {
                    View.GameSceneView.getListOfClickedButtons().removeAll(View.GameSceneView.getListOfClickedButtons());
                }
            }

            // Upgrading the towers
            else if(View.GameSceneView.getListOfClickedButtons().get(0).equals("186") ) {
                System.out.println("clicked on upgrade");
            }
            else  {
                System.out.println("not completed");
            }
        }
    }
}
