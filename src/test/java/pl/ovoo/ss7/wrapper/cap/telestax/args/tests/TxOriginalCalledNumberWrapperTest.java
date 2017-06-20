package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.isup.OriginalCalledNumberCap;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.isup.message.parameter.OriginalCalledNumber;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.OriginalCalledNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxOriginalCalledNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxOriginalCalledNumberWrapperTest extends WrapperBaseTest {

    TxOriginalCalledNumberWrapper txOriginalCalledNumberWrapper;

    @Before
    public void setUp() throws Exception {

        final OriginalCalledNumber originalCalledNumber = isupFactory.createOriginalCalledNumber();
        originalCalledNumber.setNatureOfAddresIndicator(OriginalCalledNumberWrapper.Nature.INTERNATIONAL.getValue());
        originalCalledNumber.setAddress("0048765987245");
        originalCalledNumber.setNumberingPlanIndicator(OriginalCalledNumberWrapper.NumberingPlan.ISDN.getValue());
        originalCalledNumber.setAddressRepresentationRestrictedIndicator(
                OriginalCalledNumberWrapper.Presentation.ALLOWED.getValue());

        final OriginalCalledNumberCap originalCalledNumberCap = capFactory
                .createOriginalCalledNumberCap(originalCalledNumber);

        txOriginalCalledNumberWrapper = new TxOriginalCalledNumberWrapper(originalCalledNumberCap);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txOriginalCalledNumberWrapper);
        TxOriginalCalledNumberWrapper tx = (TxOriginalCalledNumberWrapper) deserializeFromFile();

        assertTrue(tx.hasAddress());
        assertTrue(tx.hasNature());
        assertTrue(tx.hasNumberingPlan());
        assertTrue(txOriginalCalledNumberWrapper.getTxOriginalCalledNumber().getOriginalCalledNumber().getAddress()
                .equals(tx.getTxOriginalCalledNumber().getOriginalCalledNumber().getAddress()));
    }

}
