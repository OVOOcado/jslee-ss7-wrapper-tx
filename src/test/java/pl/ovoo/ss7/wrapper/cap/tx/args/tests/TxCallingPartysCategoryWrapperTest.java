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

package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.inap.api.isup.CallingPartysCategoryInap;
import org.mobicents.protocols.ss7.isup.message.parameter.CallingPartyCategory;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxCallingPartysCategoryWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxCallingPartysCategoryWrapperTest extends WrapperBaseTest {

    TxCallingPartysCategoryWrapper txCallingPartysCategoryWrapper;

    @Before
    public void setUp() throws Exception {

        CallingPartyCategory callingPartyCategory = isupFactory.createCallingPartyCategory();
        byte bt = 32;
        callingPartyCategory.setCallingPartyCategory(bt);
        CallingPartysCategoryInap callingPartysCategoryInap = inapFactory
                .createCallingPartysCategoryInap(callingPartyCategory);
        txCallingPartysCategoryWrapper = new TxCallingPartysCategoryWrapper(callingPartysCategoryInap);
    }

    @Override
    public void testSerialization() throws Ss7WrapperException, ClassNotFoundException, IOException {

        serializeToFile(txCallingPartysCategoryWrapper);
        TxCallingPartysCategoryWrapper tx = (TxCallingPartysCategoryWrapper) deserializeFromFile();

        assertTrue(txCallingPartysCategoryWrapper.getCategory().getValue() == tx.getCategory().getValue());
    }

}
