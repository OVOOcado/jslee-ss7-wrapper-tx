package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mobicents.protocols.ss7.isup.message.parameter.GenericNumber;

import pl.ovoo.ss7.wrapper.cap.args.GenericNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxAssistRequestInstructionsArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxGenericNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxAssistRequestInstructionsArgWrapperTest extends WrapperBaseTest {

    TxAssistRequestInstructionsArgWrapper txAssistRequestInstructionsArgWrapper;

    @Before
    public void setUp() throws Exception {

        txAssistRequestInstructionsArgWrapper = new TxAssistRequestInstructionsArgWrapper();

        GenericNumber genericNumber = isupFactory.createGenericNumber();
        genericNumber.setNatureOfAddresIndicator(GenericNumberWrapper.Nature.INTERNATIONAL.getValue());
        genericNumber.setAddress("0048986235172");
        genericNumber.setNumberQualifierIndicator(GenericNumber._NQIA_CALLING_PARTY_NUMBER);
        genericNumber.setScreeningIndicator(GenericNumber._SI_USER_PROVIDED_VERIFIED_FAILED);
        genericNumber.setAddressRepresentationRestrictedIndicator(123456789);
        genericNumber.setNumberIncompleter(true);
        genericNumber.setNumberingPlanIndicator(987654321);
        GenericNumberWrapper genericNumberWrapper = new TxGenericNumberWrapper(genericNumber);
        txAssistRequestInstructionsArgWrapper.setCorrelationID(genericNumberWrapper);

    }

    @Test
    public void testSerialization() throws IOException, ClassNotFoundException {

        serializeToFile(txAssistRequestInstructionsArgWrapper);
        TxAssistRequestInstructionsArgWrapper tx = (TxAssistRequestInstructionsArgWrapper) deserializeFromFile();

        assertTrue(txAssistRequestInstructionsArgWrapper.getTxCorrelationID().getNatureOfAddressIndicator() == tx
                .getTxCorrelationID().getNatureOfAddressIndicator());
        assertEquals(txAssistRequestInstructionsArgWrapper.getTxCorrelationID().getAddress(),
                tx.getTxCorrelationID().getAddress());
        assertTrue(txAssistRequestInstructionsArgWrapper.getTxCorrelationID().getCode() == tx.getTxCorrelationID()
                .getCode());
        assertTrue(txAssistRequestInstructionsArgWrapper.getTxCorrelationID().getScreeningIndicator() == tx
                .getTxCorrelationID().getScreeningIndicator());

    }

}
