package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.service.sms.primitive.RPCause;
import org.mobicents.protocols.ss7.inap.api.INAPException;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.RPCauseValue;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxRPCauseWrapperImpl;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxRPCauseWrapperImplTest extends WrapperBaseTest {

    TxRPCauseWrapperImpl txRPCauseWrapperImpl;

    @Before
    public void setUp() throws Exception {

        final RPCause rpCause = capFactory.createRPCause(RPCauseValue.DESTINATION_OUT_OF_ORDER.getValue());
        txRPCauseWrapperImpl = new TxRPCauseWrapperImpl(rpCause);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txRPCauseWrapperImpl);
        TxRPCauseWrapperImpl tx = (TxRPCauseWrapperImpl) deserializeFromFile();

        assertTrue(txRPCauseWrapperImpl.getTxRpCause().getData() == tx.getTxRpCause().getData());

    }

}
