package pl.ovoo.ss7.wrapper.map.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.map.api.primitives.CellGlobalIdOrServiceAreaIdOrLAI;
import org.mobicents.protocols.ss7.map.api.primitives.LAIFixedLength;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxMAPCellGlobalIdOrServiceAreaIdOrLAIWrapper;

public class TxMAPCellGlobalIdOrServiceAreaIdOrLAIWrapperTest extends WrapperBaseTest {

    TxMAPCellGlobalIdOrServiceAreaIdOrLAIWrapper txMAPCellGlobalIdOrServiceAreaIdOrLAIWrapper;

    @Before
    public void setUp() throws Exception {

        final LAIFixedLength laiFixedLength = mapParameterFactory.createLAIFixedLength(new byte[] { 64 });
        final CellGlobalIdOrServiceAreaIdOrLAI cellGlobalIdOrServiceAreaIdOrLAI = mapParameterFactory
                .createCellGlobalIdOrServiceAreaIdOrLAI(laiFixedLength);
        txMAPCellGlobalIdOrServiceAreaIdOrLAIWrapper = new TxMAPCellGlobalIdOrServiceAreaIdOrLAIWrapper(
                cellGlobalIdOrServiceAreaIdOrLAI);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txMAPCellGlobalIdOrServiceAreaIdOrLAIWrapper);
        TxMAPCellGlobalIdOrServiceAreaIdOrLAIWrapper tx = (TxMAPCellGlobalIdOrServiceAreaIdOrLAIWrapper) deserializeFromFile();

        assertTrue(
                txMAPCellGlobalIdOrServiceAreaIdOrLAIWrapper.getTxCellGlobalIdOrServiceAreaIdOrLAI().getLAIFixedLength()
                        .getData()[0] == tx.getTxCellGlobalIdOrServiceAreaIdOrLAI().getLAIFixedLength().getData()[0]);

    }

}
