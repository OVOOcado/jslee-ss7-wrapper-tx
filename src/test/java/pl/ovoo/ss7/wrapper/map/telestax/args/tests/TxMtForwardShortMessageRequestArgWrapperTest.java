package pl.ovoo.ss7.wrapper.map.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.primitives.*;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.common.args.AddressStringWrapper;
import pl.ovoo.ss7.wrapper.common.args.ISDNAddressStringWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.common.telestax.TxIMSIAddressWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxISDNAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.map.args.CharsetWrapper;
import pl.ovoo.ss7.wrapper.map.args.DataCodingWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxMtForwardShortMessageRequestArgWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxSmRpDaWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxSmRpOaWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxSmRpUiWrapper;

public class TxMtForwardShortMessageRequestArgWrapperTest extends WrapperBaseTest {

    TxMtForwardShortMessageRequestArgWrapper txMtForwardShortMessageRequestArgWrapper;

    @Before
    public void setUp() throws Exception {
        txMtForwardShortMessageRequestArgWrapper = new TxMtForwardShortMessageRequestArgWrapper();
        IMSI imsi = mapParameterFactory.createIMSI("260435678876987");
        TxIMSIAddressWrapper txIMSIAddressWrapper = new TxIMSIAddressWrapper(imsi);
        TxSmRpDaWrapper txSmRpDaWrapper = new TxSmRpDaWrapper();
        txSmRpDaWrapper.setIMSI(txIMSIAddressWrapper);
        txMtForwardShortMessageRequestArgWrapper.setSm_Rp_Da(txSmRpDaWrapper);

        ISDNAddressString addressString = mapParameterFactory.createISDNAddressString(AddressNature.international_number,
                NumberingPlan.ISDN, "0048657359345");
        ISDNAddressStringWrapper addressStringWrapper = new TxISDNAddressStringWrapperImpl(addressString);
        TxSmRpOaWrapper txSmRpOaWrapper = new TxSmRpOaWrapper();
        txSmRpOaWrapper.setServiceCentreAddressOa(addressStringWrapper);
        txMtForwardShortMessageRequestArgWrapper.setSm_Rp_Oa(txSmRpOaWrapper);

        TxSmRpUiWrapper txSmRpUiWrapper = new TxSmRpUiWrapper();
        txSmRpUiWrapper.setCharset(DataCodingWrapper.GSM7);
        txSmRpUiWrapper.setText("text message");
        txMtForwardShortMessageRequestArgWrapper.setSm_Rp_Ui(txSmRpUiWrapper);
        
        txMtForwardShortMessageRequestArgWrapper.setMoreMessagesToSend(true);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException {
        serializeToFile(txMtForwardShortMessageRequestArgWrapper);
        TxMtForwardShortMessageRequestArgWrapper tx = (TxMtForwardShortMessageRequestArgWrapper) deserializeFromFile();

        assertTrue(txMtForwardShortMessageRequestArgWrapper.getSm_Rp_Da().getIMSI().getAddress().equals(tx.getSm_Rp_Da().getIMSI().getAddress()));
        assertTrue(txMtForwardShortMessageRequestArgWrapper.getSm_Rp_Oa().getServiceCentreAddressOA().getNature()
                .getValue() == tx.getSm_Rp_Oa().getServiceCentreAddressOA().getNature().getValue());
        assertTrue(txMtForwardShortMessageRequestArgWrapper.getSm_Rp_Oa().getServiceCentreAddressOA().getNumberingPlan()
                .getValue() == tx.getSm_Rp_Oa().getServiceCentreAddressOA().getNumberingPlan().getValue());
        assertTrue(txMtForwardShortMessageRequestArgWrapper.getMoreMessagesToSend());
        String s1 = new String(txMtForwardShortMessageRequestArgWrapper.getSm_Rp_Ui().getText().getBytes(StandardCharsets.UTF_8),getCharsetFromGsmCoding(txMtForwardShortMessageRequestArgWrapper.getSm_Rp_Ui().getCharset().getValue()));
        String s2 = new String(tx.getSm_Rp_Ui().getText().getBytes(StandardCharsets.UTF_8),getCharsetFromGsmCoding(tx.getSm_Rp_Ui().getCharset().getValue()));


        assertTrue(s1.equals(s2));

    }

    public static Charset getCharsetFromGsmCoding(int value){
        switch(value){
            case 0:
            case 4:
                return StandardCharsets.UTF_8;
            case 8:
                return StandardCharsets.UTF_16BE;
            default:
                return null;
        }
    }
}
