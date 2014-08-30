package moviescraper.doctord.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import moviescraper.doctord.Thumb;

public class FanartPickerRenderer extends JLabel implements ListCellRenderer<Thumb> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

	public FanartPickerRenderer() {
		setOpaque(true);
		setIconTextGap(12);
	}

	public Component getListCellRendererComponent(JList<? extends Thumb> list, Thumb value,
			int index, boolean isSelected, boolean cellHasFocus) {
		Thumb entry = (Thumb) value;
		ImageIcon currentIcon = entry.getPreviewImageIconThumbImage();
		//no preview image so let's just try to resize it
		if(currentIcon == null)
		{
			currentIcon = entry.getImageIconThumbImage();
			Image scaledImg = currentIcon.getImage().getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
			currentIcon = new ImageIcon(scaledImg);
		}
		if(currentIcon != null)
		{
			//ImageIcon currentIcon = entry.getImageIconThumbImage();
			//Image scaledImg = currentIcon.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
			//currentIcon = new ImageIcon(scaledImg);
			setIcon(currentIcon);
		}
		if (isSelected) {
			setBackground(HIGHLIGHT_COLOR);
			setForeground(Color.white);
		} else {
			setBackground(Color.white);
			setForeground(Color.black);
		}
		return this;
	}

}
