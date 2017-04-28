package opengl;


import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class HelloWorld extends JFrame {
	Renderer listener = new Renderer();
	static FPSAnimator animator = null;

	public HelloWorld() throws HeadlessException {
		super("title");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GLCapabilities glcaps = new GLCapabilities(null); // �����֮ǰ�½ڵĴ���������.
		GLCanvas canvas = new GLCanvas(glcaps);
		canvas.addGLEventListener(listener);
		// canvas.addMouseListener(listener);
		getContentPane().add(canvas, BorderLayout.CENTER);
		animator = new FPSAnimator(canvas, 500, true);

		centerWindow(this);
	}

	private void centerWindow(Component frame) { // ���д���
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize();
		if (frameSize.width > screenSize.width)
			frameSize.width = screenSize.width;
		if (frameSize.height > screenSize.height)
			frameSize.height = screenSize.height;
		frame.setLocation((screenSize.width - frameSize.width) >> 1,
				(screenSize.height - frameSize.height) >> 1);

	}

	public static void main(String[] args) {
		final HelloWorld app = new HelloWorld();
		// ��ʾ����
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				app.setVisible(true);
			}
		});
		// �����߳̿�ʼ
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				animator.start();
			}
		});
	}
}
