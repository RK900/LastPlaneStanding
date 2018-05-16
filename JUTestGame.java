package LastPlaneStanding;

import junit.framework.JUnit4TestAdapter;

public class JUTestGame
{

    public static junit.framework.Test suite()
    {
        return new JUnit4TestAdapter( JUTestGame.class );
    }

    public static void main( String args[] )
    {
        org.junit.runner.JUnitCore.main( "JUTestNumber" );
    }
}
