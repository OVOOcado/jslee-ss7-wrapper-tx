package pl.ovoo.ss7.wrapper.map.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.map.api.primitives.CellGlobalIdOrServiceAreaIdFixedLength;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxCellGlobalIdWrapper;

public class TxCellGlobalIdWrapperTest extends WrapperBaseTest {

	TxCellGlobalIdWrapper txCellGlobalIdWrapper;

	@Before
	public void setUp() throws Exception {

		CellGlobalIdOrServiceAreaIdFixedLength cellGlobalIdOrServiceAreaIdFixedLength = mapParameterFactory
				.createCellGlobalIdOrServiceAreaIdFixedLength(1, 1, 1, 1);

		txCellGlobalIdWrapper = new TxCellGlobalIdWrapper(cellGlobalIdOrServiceAreaIdFixedLength);
	}

	@Override
	public void testSerialization()
			throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

		serializeToFile(txCellGlobalIdWrapper);
		TxCellGlobalIdWrapper tx = (TxCellGlobalIdWrapper) deserializeFromFile();

		assertTrue(txCellGlobalIdWrapper.getCellId() == tx.getCellId());
		assertTrue(txCellGlobalIdWrapper.getLocationAreaCode() == tx.getLocationAreaCode());
	}

}
