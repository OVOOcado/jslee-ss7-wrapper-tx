/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.map.telestax.args;

import org.mobicents.protocols.ss7.map.api.primitives.CellGlobalIdOrServiceAreaIdOrLAI;
import pl.ovoo.ss7.wrapper.map.args.CellGlobalIdWrapper;
import pl.ovoo.ss7.wrapper.map.args.MAPCellGlobalIdOrServiceAreaIdOrLAIWrapper;

/**
 * TxMAPCellGlobalIdOrServiceAreaIdOrLAIWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxMAPCellGlobalIdOrServiceAreaIdOrLAIWrapper implements MAPCellGlobalIdOrServiceAreaIdOrLAIWrapper {

    private transient CellGlobalIdWrapper cellGlobalIdWrapper = null;

    private final CellGlobalIdOrServiceAreaIdOrLAI cellGlobalIdOrServiceAreaIdOrLAI;

    public TxMAPCellGlobalIdOrServiceAreaIdOrLAIWrapper(
            final CellGlobalIdOrServiceAreaIdOrLAI cellGlobalIdOrServiceAreaIdOrLAI) {
        this.cellGlobalIdOrServiceAreaIdOrLAI = cellGlobalIdOrServiceAreaIdOrLAI;
    }

    @Override
    public boolean isCellGlobalIdOrServiceAreaIdFixedLengthChosen() {
        return cellGlobalIdOrServiceAreaIdOrLAI.getCellGlobalIdOrServiceAreaIdFixedLength() != null
                && cellGlobalIdOrServiceAreaIdOrLAI.getLAIFixedLength() == null;
    }

    @Override
    public CellGlobalIdWrapper getCellGlobalIdOrServiceAreaIdFixedLength() {
        if (this.cellGlobalIdWrapper == null
                && this.cellGlobalIdOrServiceAreaIdOrLAI.getCellGlobalIdOrServiceAreaIdFixedLength() != null) {
            this.cellGlobalIdWrapper = new TxCellGlobalIdWrapper(
                    cellGlobalIdOrServiceAreaIdOrLAI.getCellGlobalIdOrServiceAreaIdFixedLength());
        }
        return this.cellGlobalIdWrapper;
    }

    public CellGlobalIdOrServiceAreaIdOrLAI getTxCellGlobalIdOrServiceAreaIdOrLAI() {
        return cellGlobalIdOrServiceAreaIdOrLAI;
    }

    @Override
    public String toString() {
        return "TxMAPCellGlobalIdOrServiceAreaIdOrLAIWrapper [cellGlobalIdOrServiceAreaIdOrLAI="
                + cellGlobalIdOrServiceAreaIdOrLAI + "]";
    }

}
