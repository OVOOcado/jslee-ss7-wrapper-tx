package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.inap.api.primitives.LegID;
import org.mobicents.protocols.ss7.inap.api.primitives.LegType;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxLegIDWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxLegIDWrapperTest extends WrapperBaseTest {

    TxLegIDWrapper txLegIDWrapper;

    @Before
    public void setUp() throws Exception {

        LegID leg = inapFactory.createLegID(true, LegType.leg3);
        txLegIDWrapper = new TxLegIDWrapper(leg);

    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txLegIDWrapper);
        TxLegIDWrapper tx = (TxLegIDWrapper) deserializeFromFile();

        assertTrue(txLegIDWrapper.getTxLegID().getSendingSideID().getCode() == tx.getTxLegID().getSendingSideID()
                .getCode());
    }

}
