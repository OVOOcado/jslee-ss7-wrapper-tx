/*
 * JSLEE SS7 Wrapper Tx
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the JSLEE SS7 Wrapper Tx.
 *
 * JSLEE SS7 Wrapper Tx is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * JSLEE SS7 Wrapper Tx is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pl.ovoo.jslee.ss7.wrapper.map.tx.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.map.api.primitives.CellGlobalIdOrServiceAreaIdFixedLength;

import pl.ovoo.jslee.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxCellGlobalIdWrapper;
import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;

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
