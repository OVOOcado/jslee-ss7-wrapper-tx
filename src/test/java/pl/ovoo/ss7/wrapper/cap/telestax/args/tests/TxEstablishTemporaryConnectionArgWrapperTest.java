package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.isup.message.parameter.GenericDigits;
import org.mobicents.protocols.ss7.isup.message.parameter.GenericNumber;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.GenericDigitsWrapper;
import pl.ovoo.ss7.wrapper.cap.args.GenericNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxEstablishTemporaryConnectionArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxGenericDigitsWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxGenericNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxEstablishTemporaryConnectionArgWrapperTest extends WrapperBaseTest {

    TxEstablishTemporaryConnectionArgWrapper txEstablishTemporaryConnectionArgWrapper;

    @Before
    public void setUp() throws Exception {

        txEstablishTemporaryConnectionArgWrapper = new TxEstablishTemporaryConnectionArgWrapper();

        GenericDigits genericDigits = isupFactory.createGenericDigits();
        genericDigits.setDecodedDigits(2, "0048567456946");
        genericDigits.setEncodedDigits(new byte[] { 64 });
        genericDigits.setTypeOfDigits(GenericDigits._TOD_AUTHORIZATION_CODE);
        genericDigits.setEncodingScheme(GenericDigits._ENCODING_SCHEME_BCD_ODD);
        GenericDigitsWrapper genericDigitsWrapper = new TxGenericDigitsWrapper(genericDigits);

        txEstablishTemporaryConnectionArgWrapper.setAssistingDialogCorrelationID(genericDigitsWrapper);

        GenericNumber genericNumber = isupFactory.createGenericNumber();
        genericNumber.setAddressRepresentationRestrictedIndicator(1);
        genericNumber.setNumberIncompleter(true);
        genericNumber.setNumberingPlanIndicator(GenericNumberWrapper.NumberingPlan.ISDN.getValue());
        genericNumber.setScreeningIndicator(GenericNumber._SI_USER_PROVIDED_VERIFIED_FAILED);
        genericNumber.setNatureOfAddresIndicator(GenericNumberWrapper.Nature.INTERNATIONAL.getValue());
        genericNumber.setAddress("0048231757215");
        GenericNumberWrapper genericNumberWrapper = new TxGenericNumberWrapper(genericNumber);

        txEstablishTemporaryConnectionArgWrapper.setAssistingSSPIPRoutingAddress(genericNumberWrapper);
    }

    @Override
    public void testSerialization() throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException {

        serializeToFile(txEstablishTemporaryConnectionArgWrapper);
        TxEstablishTemporaryConnectionArgWrapper tx = (TxEstablishTemporaryConnectionArgWrapper) deserializeFromFile();

        assertTrue(txEstablishTemporaryConnectionArgWrapper.getTxAssistingDialogCorrelationID()
                .getEncodingScheme() == tx.getTxAssistingDialogCorrelationID().getEncodingScheme());
        assertTrue(txEstablishTemporaryConnectionArgWrapper.getTxAssistingDialogCorrelationID().getTypeOfDigits() == tx
                .getTxAssistingDialogCorrelationID().getTypeOfDigits());
        assertTrue(txEstablishTemporaryConnectionArgWrapper.getTxAssistingSSPIPRoutingAddress()
                .getNatureOfAddressIndicator() == tx.getTxAssistingSSPIPRoutingAddress().getNatureOfAddressIndicator());
        assertTrue(txEstablishTemporaryConnectionArgWrapper.getTxAssistingSSPIPRoutingAddress().getAddress()
                .equals(tx.getTxAssistingSSPIPRoutingAddress().getAddress()));
        assertTrue(txEstablishTemporaryConnectionArgWrapper.getTxAssistingDialogCorrelationID().getCode() == tx
                .getTxAssistingDialogCorrelationID().getCode());
        assertTrue(txEstablishTemporaryConnectionArgWrapper.getTxAssistingSSPIPRoutingAddress().getCode() == tx
                .getTxAssistingSSPIPRoutingAddress().getCode());
        assertTrue(txEstablishTemporaryConnectionArgWrapper.getTxAssistingSSPIPRoutingAddress()
                .getScreeningIndicator() == tx.getTxAssistingSSPIPRoutingAddress().getScreeningIndicator());
    }

}
