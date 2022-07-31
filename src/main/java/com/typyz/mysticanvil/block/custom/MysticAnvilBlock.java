package com.typyz.mysticanvil.block.custom;



import com.typyz.mysticanvil.mysticAnvil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nonnull;
import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;


public class MysticAnvilBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;



    private static final Map<Direction, VoxelShape> SHAPES = new EnumMap<>(Direction.class);

    private static final Optional<VoxelShape> SHAPE = Stream.of(
            Block.box(1.125, 0, 0.875, 15.125, 9, 14.875),
            Block.box(14.125, 9, 0.875, 15.125, 10, 14.875),
            Block.box(1.125, 9, 0.875, 15.125, 10, 1.875),
            Block.box(1.125, 9, 13.875, 15.125, 10, 14.875),
            Block.box(1.125, 9, 0.875, 2.125, 10, 14.875),
            Block.box(0.875, 15, 6.875, 1.875, 16, 8.875),
            Block.box(1.875, 15, 6.375, 2.875, 16, 9.375),
            Block.box(2.125, 14.125, 6.625, 3.125, 15.125, 9.125),
            Block.box(3.125, 14, 5.875, 4.125, 15, 9.875),
            Block.box(2.875, 15, 5.625, 3.875, 16, 10.125),
            Block.box(3.875, 15, 4.525, 12.875, 16, 11.225),
            Block.box(4.125, 14, 5.125, 12.125, 15, 10.625),
            Block.box(1.125, 14.25, 7.125, 2.125, 15.25, 8.625),
            Block.box(3.625, 9, 10.875, 5.625, 10, 12.875),
            Block.box(10.625, 9, 10.875, 12.625, 10, 12.875),
            Block.box(10.625, 9, 2.875, 12.625, 10, 4.875),
            Block.box(3.625, 9, 2.875, 5.625, 10, 4.875),
            Block.box(11.125, 9.25, 3.375, 12.125, 10.25, 4.375),
            Block.box(11.125, 9.25, 11.375, 12.125, 10.25, 12.375),
            Block.box(4.125, 9.25, 11.375, 5.125, 10.25, 12.375),
            Block.box(4.125, 9.25, 3.375, 5.125, 10.25, 4.375),
            Block.box(3.125, 9, 4.875, 13.125, 10, 10.875),
            Block.box(4.125, 10, 5.875, 12.125, 11, 9.875),
            Block.box(5.125, 11, 6.175, 11.125, 14, 9.575)
            ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR));

    public MysticAnvilBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(FACING, Direction.NORTH));
        runCalculation(SHAPE.orElse(Shapes.block()));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPES.get(state.getValue(FACING));
    }

    protected void runCalculation(VoxelShape shape) {
        for (Direction direction : Direction.values())
            SHAPES.put(direction, mysticAnvil.calculateShapes(direction, shape));
    }

    /* FACING */

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
   }
}