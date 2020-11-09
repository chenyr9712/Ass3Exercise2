import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphView extends JFrame {

	private static final long serialVersionUID = 1L;
	private GraphPanel panel;

	/**
	 * Create the frame.
	 */
	public GraphView() {
		setTitle("GraphView");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panel = new GraphPanel();
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel);
	}

	public void update(Model model) {
		panel.setModel(model);
		panel.repaint();
	}

	class GraphPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private int HEIGHT = 250;
		private int offsetY = 14;
		private Font font = new Font("Times", Font.PLAIN, 14);

		private Model model=new Model(0, 0, 0);

		@Override
		public void setBackground(Color bg) {
			// TODO Auto-generated method stub
			super.setBackground(bg);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			HEIGHT = (int) (getHeight()-50);
			int width = getWidth();
			int w80 = (int) (width * 0.8);
			int w20 = (int) (width * 0.2);
			int uw = w80 / 3;
			int gap = w20 / 4;
			
			double max=1.0;
			if(model.getRed()>max)
			{
				max=model.getRed();
			}
			if(model.getGreen()>max)
			{
				max=model.getGreen();
			}
			if(model.getBlue()>max)
			{
				max=model.getBlue();
			}
			
			String str;
			g.setFont(font);
			int bottom = getHeight() - 20;
			 
			int rectH = (int) (HEIGHT * ( model.getRed()/max)); 
			g.setColor(Color.RED);
			g.fillRect(gap, bottom - rectH, uw, rectH);
			g.setColor(Color.BLACK);
			str = "Red -- " + model.getRed();
			g.drawString(str, gap, bottom - rectH - offsetY);

			rectH = (int) (HEIGHT * ( model.getGreen()/max ));
			g.setColor(Color.green);
			g.fillRect(gap * 2 + uw, bottom - rectH, uw, rectH);
			g.setColor(Color.BLACK);
			str = "Green -- " + model.getGreen();
			g.drawString(str, gap * 2 + uw, bottom - rectH - offsetY);

			rectH = (int) (HEIGHT * (model.getBlue()/max*1.0));
			g.setColor(Color.blue);
			g.fillRect(gap * 3 + uw * 2, bottom - rectH, uw, rectH);
			g.setColor(Color.BLACK);
			str = "Blue -- " + model.getBlue();
			g.drawString(str, gap * 3 + uw * 2, bottom - rectH - offsetY);

		}

		public Model getModel() {
			return model;
		}

		public void setModel(Model model) {
			this.model = model;
		}
	}

}
