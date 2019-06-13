import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Main {
	static Dimension frameSize = new Dimension(800, 600);
	static Dimension canvasSize = new Dimension((int)(frameSize.width * .8), (int)(frameSize.height * .9));

	public static void main(String[] args) {
		// JFrameのインスタンスを生成
        Frame frame = new Frame("Sort Algorithms", frameSize);
        // ウィンドウを閉じたらプログラムを終了する
        // frame.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
        // ウィンドウのサイズ・初期位置
        // frame.setSize(frameSize);
        // frame.setLocationRelativeTo(null);
		// setBounds(x, y, w, h);
		
		GraphCanvas cvs = new GraphCanvas(canvasSize);
		JPanel pnl = new JPanel();
		JPanel ui = new JPanel();
		cvs.setBackground(Color.WHITE);
		pnl.add(cvs);
		pnl.setBackground(Color.GRAY);
		pnl.setBorder(new LineBorder(Color.RED));
		
		// frame.getContentPane().add(pnl);
		// frame.getContentPane().add(ui);
		frame.addComponent(pnl, 0, 0, 1, 1);
		frame.addComponent(ui, 0, 1, 1, 1);

        // ウィンドウを表示
        frame.setVisible(true);
	}

	public static class Frame extends JFrame {
		public GridBagLayout layout = new GridBagLayout();
		private GridBagConstraints gbc = new GridBagConstraints();

		public Frame(String title, Dimension dim) {
			super(title);
			setLayout(layout);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setSize(dim);
			setLocationRelativeTo(null);
			init();
			setVisible(true);

			addComponentListener(new ComponentAdapter() {
				@Override
				public void componentResized(ComponentEvent e) {
					// System.out.println(getWidth());
					// frameSize = new Dimension(getWidth(), getHeight());
					revalidate();
				}
			});
		}
		public void init() {
		}
		public void addComponent(Component c, GridBagConstraints gbc) {
			layout.setConstraints(c, gbc);
			add(c);
		}
		public void addComponent(Component c, int x, int y, int w, int h) {
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = x;
			gbc.gridy = y;
			gbc.gridwidth = w;
			gbc.gridheight = h;
			addComponent(c, gbc);
		}
	}
	public static class GraphCanvas extends Canvas {
		public GraphCanvas(Dimension initDim) {
			setPreferredSize(initDim);
		}
		public void paint(Graphics graphics) {
			graphics.setColor(Color.RED);
			graphics.drawRect(10, 10, 120, 50);
		}
	}
}