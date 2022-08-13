/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author Administrator
 */
public class ContextMenuStripDangSD extends JPopupMenu{
    public JMenuItem menu1, menu2, menu3,menu4;
	
	public ContextMenuStripDangSD() {
		menu1 = new JMenuItem("Trả phòng ");
		add(menu1);
		addSeparator();
		menu2 = new JMenuItem("Dịch vụ");
		add(menu2);
		
		// Thêm thanh ngăn cách
		addSeparator();
		
		menu3 = new JMenuItem("Thêm phòng mới");
		add(menu3);
                addSeparator();
                menu4 = new JMenuItem("Chuyển phòng");
		add(menu4);
	}
}
