package com.example.springboot_react_example.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoardEntity is a Querydsl query type for BoardEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoardEntity extends EntityPathBase<BoardEntity> {

    private static final long serialVersionUID = -970765006L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoardEntity boardEntity = new QBoardEntity("boardEntity");

    public final ListPath<Comment, QComment> commentList = this.<Comment, QComment>createList("commentList", Comment.class, QComment.class, PathInits.DIRECT2);

    public final StringPath contents = createString("contents");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final StringPath createdBy = createString("createdBy");

    public final ListPath<FileEntity, QFileEntity> fileEntityList = this.<FileEntity, QFileEntity>createList("fileEntityList", FileEntity.class, QFileEntity.class, PathInits.DIRECT2);

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final QMember member;

    public final StringPath title = createString("title");

    public QBoardEntity(String variable) {
        this(BoardEntity.class, forVariable(variable), INITS);
    }

    public QBoardEntity(Path<? extends BoardEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoardEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoardEntity(PathMetadata metadata, PathInits inits) {
        this(BoardEntity.class, metadata, inits);
    }

    public QBoardEntity(Class<? extends BoardEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

