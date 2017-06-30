package pl.ovoo.ss7.wrapper.map.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

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
import pl.ovoo.ss7.wrapper.map.telestax.args.TxMtForwardShortMessageRequestArgWrapper;

public class TxMtForwardShortMessageRequestArgWrapperTest extends WrapperBaseTest {

    TxMtForwardShortMessageRequestArgWrapper txMtForwardShortMessageRequestArgWrapper;

    @Before
    public void setUp() throws Exception {
        txMtForwardShortMessageRequestArgWrapper = new TxMtForwardShortMessageRequestArgWrapper();
        IMSI imsi = mapParameterFactory.createIMSI("260435678876987");
        TxIMSIAddressWrapper txIMSIAddressWrapper = new TxIMSIAddressWrapper(imsi);
        txMtForwardShortMessageRequestArgWrapper.setImsi(txIMSIAddressWrapper);
        ISDNAddressString addressString = mapParameterFactory.createISDNAddressString(AddressNature.international_number,
                NumberingPlan.ISDN, "0048657359345");
        ISDNAddressStringWrapper addressStringWrapper = new TxISDNAddressStringWrapperImpl(addressString);
        txMtForwardShortMessageRequestArgWrapper.setServiceCentreAddressOA(addressStringWrapper);
        txMtForwardShortMessageRequestArgWrapper.setText("test message");
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException {
        serializeToFile(txMtForwardShortMessageRequestArgWrapper);
        TxMtForwardShortMessageRequestArgWrapper tx = (TxMtForwardShortMessageRequestArgWrapper) deserializeFromFile();

        assertTrue(txMtForwardShortMessageRequestArgWrapper.getTxIMSI().getData().equals(tx.getTxIMSI().getData()));
        assertTrue(txMtForwardShortMessageRequestArgWrapper.getIMSI().getAddress().equals(tx.getIMSI().getAddress()));
        assertTrue(txMtForwardShortMessageRequestArgWrapper.getTxServiceCentreAddressOA().getAddressNature()
                .getIndicator() == tx.getTxServiceCentreAddressOA().getAddressNature().getIndicator());
        assertTrue(txMtForwardShortMessageRequestArgWrapper.getTxServiceCentreAddressOA().getNumberingPlan()
                .getIndicator() == tx.getTxServiceCentreAddressOA().getNumberingPlan().getIndicator());
        assertTrue(txMtForwardShortMessageRequestArgWrapper.getText().equals(tx.getText()));

    }

}
