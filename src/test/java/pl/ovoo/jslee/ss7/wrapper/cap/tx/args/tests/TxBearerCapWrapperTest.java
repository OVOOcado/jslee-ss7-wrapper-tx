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

package pl.ovoo.jslee.ss7.wrapper.cap.tx.args.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.isup.BearerCap;
import org.mobicents.protocols.ss7.isup.message.parameter.UserServiceInformation;
import org.mobicents.protocols.ss7.isup.message.parameter.UserServiceInformationBase;

import pl.ovoo.jslee.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxBearerCapWrapper;


/**
 * The Class TxBearerCapWrapperTest.
 */
public class TxBearerCapWrapperTest extends WrapperBaseTest {

	/** The tx bearer cap wrapper. */
	TxBearerCapWrapper txBearerCapWrapper;

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
	    
		UserServiceInformation createUserServiceInformation = isupFactory.createUserServiceInformation();
		createUserServiceInformation.setCodingStandart(UserServiceInformation._CS_INTERNATIONAL);
		createUserServiceInformation.setCustomInformationTransferRate(UserServiceInformationBase._ITR_1536);
		createUserServiceInformation.setInformationTransferCapability(UserServiceInformation._ITR_MULTIRATE);
		BearerCap bearerCap = capFactory.createBearerCap(createUserServiceInformation);
		txBearerCapWrapper = new TxBearerCapWrapper(bearerCap);

	}

	/* (non-Javadoc)
	 * @see pl.ovoo.jslee.ss7.wrapper.cap.test.WrapperBaseTest#testSerialization()
	 */
	@Test
	public void testSerialization() throws ClassNotFoundException, IOException, CAPException {
	    
		serializeToFile(txBearerCapWrapper);
		TxBearerCapWrapper tx = (TxBearerCapWrapper) deserializeFromFile();

		assertTrue(txBearerCapWrapper.getTxBearerCap().getUserServiceInformation().getCodingStandart() == tx
				.getTxBearerCap().getUserServiceInformation().getCodingStandart());
		assertTrue(
				txBearerCapWrapper.getTxBearerCap().getUserServiceInformation().getInformationTransferCapability() == tx
						.getTxBearerCap().getUserServiceInformation().getInformationTransferCapability());
	}

}
