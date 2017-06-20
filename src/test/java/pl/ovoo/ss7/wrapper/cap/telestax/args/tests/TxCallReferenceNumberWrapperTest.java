package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.map.api.service.callhandling.CallReferenceNumber;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxCallReferenceNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxCallReferenceNumberWrapperTest extends WrapperBaseTest {

    TxCallReferenceNumberWrapper txCallReferenceNumberWrapper;

    @Before
    public void setUp() throws Exception {

        CallReferenceNumber callReferenceNumber = mapParameterFactory.createCallReferenceNumber(new byte[] { 16 });
        txCallReferenceNumberWrapper = new TxCallReferenceNumberWrapper(callReferenceNumber);
    }

    @Override
    public void testSerialization() throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException {

        serializeToFile(txCallReferenceNumberWrapper);
        TxCallReferenceNumberWrapper tx = (TxCallReferenceNumberWrapper) deserializeFromFile();

        assertTrue(txCallReferenceNumberWrapper.getTxCallReferenceNumber().getData()[0] == tx.getTxCallReferenceNumber()
                .getData()[0]);

    }

}
