package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.*;
import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxCancelArgWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxCancelArgWrapperTest extends WrapperBaseTest {

    TxCancelArgWrapper txCancelArgWrapper;

    @Before
    public void setUp() throws Exception {

        txCancelArgWrapper = new TxCancelArgWrapper();
        txCancelArgWrapper.setAllRequests();
    }

    @Override
    public void testSerialization() throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException {

        serializeToFile(txCancelArgWrapper);
        TxCancelArgWrapper tx = (TxCancelArgWrapper) deserializeFromFile();

        assertTrue(txCancelArgWrapper.isTxAllRequests() == tx.isTxAllRequests());

    }

}
