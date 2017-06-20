package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.isup.RedirectingPartyIDCap;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.isup.message.parameter.RedirectingNumber;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxRedirectingPartyNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxRedirectingPartyNumberWrapperTest extends WrapperBaseTest {

    TxRedirectingPartyNumberWrapper txRedirectingPartyNumberWrapper;

    @Before
    public void setUp() throws Exception {

        final RedirectingNumber redirectingNumber = isupFactory.createRedirectingNumber();
        redirectingNumber.setNatureOfAddresIndicator(RedirectingNumber._NAI_INTERNATIONAL_NUMBER);
        redirectingNumber.setNumberingPlanIndicator(RedirectingNumber._NPI_TELEX);
        redirectingNumber.setAddressRepresentationRestrictedIndicator(RedirectingNumber._APRI_RESTRICTED);
        redirectingNumber.setAddress("0048567234978");
        final RedirectingPartyIDCap redirectingPartyIDCap = capFactory.createRedirectingPartyIDCap(redirectingNumber);
        txRedirectingPartyNumberWrapper = new TxRedirectingPartyNumberWrapper(redirectingPartyIDCap);

    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txRedirectingPartyNumberWrapper);
        TxRedirectingPartyNumberWrapper tx = (TxRedirectingPartyNumberWrapper) deserializeFromFile();

        assertTrue(txRedirectingPartyNumberWrapper.getAddress().equals(tx.getAddress()));
        assertTrue(txRedirectingPartyNumberWrapper.getNature().getValue() == tx.getNature().getValue());
        assertTrue(txRedirectingPartyNumberWrapper.getNumberingPlan().equals(tx.getNumberingPlan()));
        assertTrue(txRedirectingPartyNumberWrapper.getPresentation().equals(tx.getPresentation()));

    }

}
