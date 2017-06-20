package pl.ovoo.ss7.wrapper.cap.telestax.args.cap2.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.primitives.ReceivingSideID;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.inap.api.primitives.LegType;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.ReceivingSideIDWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxReceivingSideIDWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap2.TxCap2CallInformationReportArgWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxCap2CallInformationReportArgWrapperTest extends WrapperBaseTest {

    TxCap2CallInformationReportArgWrapper txCap2CallInformationReportArgWrapper;

    @Before
    public void setUp() throws Exception {

        txCap2CallInformationReportArgWrapper = new TxCap2CallInformationReportArgWrapper();

        final ReceivingSideID receivingSideID = capFactory.createReceivingSideID(LegType.leg2);
        ReceivingSideIDWrapper receivingSideIDWrapper = new TxReceivingSideIDWrapper(receivingSideID);
        txCap2CallInformationReportArgWrapper.setLegID(receivingSideIDWrapper);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txCap2CallInformationReportArgWrapper);
        TxCap2CallInformationReportArgWrapper tx = (TxCap2CallInformationReportArgWrapper) deserializeFromFile();

        assertTrue(txCap2CallInformationReportArgWrapper.getLegID().getReceivingSideID().getValue() == tx.getLegID()
                .getReceivingSideID().getValue());
    }

}
