package opengl;


import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

class Renderer implements GLEventListener {
    private GLU glu = new GLU();
    double k = 0;
    int flag;

    public void display(GLAutoDrawable gLDrawable) {
        float length = 0.004f;
        final GL2 gl = gLDrawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        gl.glTranslatef(-1.5f, 0.0f, -6.0f);
        //gl.glPointSize();
        gl.glColor3i(20, 100, 8);
        if (flag == 0)
            k += length;
        if (flag == 1)
            k -= length;
        if (k > 1) flag = 1;
        else if (k < 0) flag = 0;

        for (double i = 0; i < 1; i += length)
            for (double j = 0; j < 1; j += length) {
                gl.glColor3d(i, j, k);
                gl.glBegin(GL2.GL_POINTS);

                gl.glVertex2d(i * 2.1, j * 2.1);
                gl.glEnd();
                gl.glFlush();
            }


//		System.out.println(k);
    }

    public void displayChanged(GLAutoDrawable gLDrawable, boolean modeChanged,
                               boolean deviceChanged) {
        System.out.println("displayChanged called");
    }

    public void init(GLAutoDrawable gLDrawable) {
        System.out.println("init() called");
        GL2 gl = gLDrawable.getGL().getGL2();
        gl.glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
        gl.glShadeModel(GL2.GL_FLAT);
    }

    public void reshape(GLAutoDrawable gLDrawable, int x, int y, int width,
                        int height) {
        System.out.println("reshape() called: x = " + x + ", y = " + y
                + ", width = " + width + ", height = " + height);
        final GL2 gl = gLDrawable.getGL().getGL2();

        if (height <= 0) // avoid a divide by zero error!
        {
            height = 1;
        }

        final float h = (float) width / (float) height;

        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void dispose(GLAutoDrawable arg0) {
        System.out.println("dispose() called");
    }
}
