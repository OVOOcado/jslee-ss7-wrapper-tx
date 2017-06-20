package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.inap.api.primitives.MiscCallInfo;
import org.mobicents.protocols.ss7.inap.api.primitives.MiscCallInfoDpAssignment;
import org.mobicents.protocols.ss7.inap.api.primitives.MiscCallInfoMessageType;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxMiscCallInfoWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxMiscCallInfoWrapperTest extends WrapperBaseTest {

    TxMiscCallInfoWrapper txMiscCallInfoWrapper;

    @Before
    public void setUp() throws Exception {

        final MiscCallInfo miscCallInfo = inapFactory.createMiscCallInfo(MiscCallInfoMessageType.notification,
                MiscCallInfoDpAssignment.groupBased);
        txMiscCallInfoWrapper = new TxMiscCallInfoWrapper(miscCallInfo);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txMiscCallInfoWrapper);
        TxMiscCallInfoWrapper tx = (TxMiscCallInfoWrapper) deserializeFromFile();

        assertTrue(txMiscCallInfoWrapper.getTxMiscCallInfo().getDpAssignment().getCode() == tx.getTxMiscCallInfo()
                .getDpAssignment().getCode());
        assertTrue(txMiscCallInfoWrapper.getTxMiscCallInfo().getMessageType().getCode() == tx.getTxMiscCallInfo()
                .getMessageType().getCode());

    }

}
