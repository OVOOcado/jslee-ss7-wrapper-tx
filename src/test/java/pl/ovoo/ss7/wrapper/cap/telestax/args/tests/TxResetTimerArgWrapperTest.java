package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.TimerID;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxResetTimerArgWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxResetTimerArgWrapperTest extends WrapperBaseTest {

    TxResetTimerArgWrapper txResetTimerArgWrapper;

    @Before
    public void setUp() throws Exception {

        txResetTimerArgWrapper = new TxResetTimerArgWrapper();

        txResetTimerArgWrapper.setTimerID(TimerID.tssf);
        txResetTimerArgWrapper.setTimerValue(60);

    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txResetTimerArgWrapper);
        TxResetTimerArgWrapper tx = (TxResetTimerArgWrapper) deserializeFromFile();

        assertTrue(txResetTimerArgWrapper.getTxTimerID().getCode() == tx.getTxTimerID().getCode());
        assertTrue(txResetTimerArgWrapper.getTxTimerValue() == tx.getTxTimerValue());
    }

}
