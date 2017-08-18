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
import org.mobicents.protocols.ss7.cap.api.primitives.SendingSideID;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.CAMELAChBillingChargingCharacteristics;
import org.mobicents.protocols.ss7.inap.api.primitives.LegType;

import pl.ovoo.jslee.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxAChBillingChargingCharacteristicsWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxApplyChargingArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxSendingSideIDWrapper;


/**
 * The Class TxApplyChargingArgWrapperTest.
 */
public class TxApplyChargingArgWrapperTest extends WrapperBaseTest {

    /** The tx apply charging arg wrapper. */
    TxApplyChargingArgWrapper txApplyChargingArgWrapper;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {

        txApplyChargingArgWrapper = new TxApplyChargingArgWrapper();

        CAMELAChBillingChargingCharacteristics cAMELAChBillingChargingCharacteristics = capFactory
                .createCAMELAChBillingChargingCharacteristics(new byte[] { 8 });
        TxAChBillingChargingCharacteristicsWrapper txAChBillingChargingCharacteristicsWrapper = new TxAChBillingChargingCharacteristicsWrapper(
                cAMELAChBillingChargingCharacteristics);
        txApplyChargingArgWrapper.setAChBillingChargingCharacteristics(txAChBillingChargingCharacteristicsWrapper);

        LegType legType = LegType.leg1;
        SendingSideID sendingSideID = capFactory.createSendingSideID(legType);
        TxSendingSideIDWrapper txSendingSideIDWrapper = new TxSendingSideIDWrapper(sendingSideID);
        txApplyChargingArgWrapper.setPartyToCharge(txSendingSideIDWrapper);
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.test.WrapperBaseTest#testSerialization()
     */
    @Test
    public void testSerialization() throws IOException, ClassNotFoundException {
        serializeToFile(txApplyChargingArgWrapper);
        TxApplyChargingArgWrapper tx = (TxApplyChargingArgWrapper) deserializeFromFile();

        assertTrue(txApplyChargingArgWrapper.getTxAchBillingChargingCharacteristics().getData()[0] == tx
                .getTxAchBillingChargingCharacteristics().getData()[0]);
        assertTrue(txApplyChargingArgWrapper.getTxPartyToCharge().getSendingSideID().getCode() == tx
                .getTxPartyToCharge().getSendingSideID().getCode());
    }

}
